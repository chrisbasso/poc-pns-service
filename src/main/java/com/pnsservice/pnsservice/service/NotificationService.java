package com.pnsservice.pnsservice.service;

import com.google.api.core.ApiFuture;
import com.google.firebase.messaging.*;
import com.kinoroy.expo.push.*;
import com.kinoroy.expo.push.Message;
import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.document.PushNotification;
import com.pnsservice.pnsservice.document.Ticket;
import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.dto.PushResponse;
import com.pnsservice.pnsservice.repository.AfiliadoRepository;
import com.pnsservice.pnsservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotificationService
{
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Autowired
    private AfiliadoService afiliadoService;

    public ApiFuture<BatchResponse> sendFireBaseMessage(PushNotification pushNotification)
    {
        Set<String> tokens = afiliadoRepository.findByCredencial(pushNotification.getCredencial())
                .getTokens().stream().map(Token::getNativeToken).collect(Collectors.toSet());

        MulticastMessage messages = MulticastMessage.builder()
                .addAllTokens(tokens)
                .setNotification(new Notification(pushNotification.getTitle(), pushNotification.getText()))
                .setAndroidConfig(AndroidConfig.builder()
                        .setNotification(AndroidNotification.builder().setTitle(pushNotification.getTitle())
                                .setBody(pushNotification.getText())
                                .build())
                        .build())
                .build();

        return FirebaseMessaging.getInstance().sendMulticastAsync(messages);
    }

    public PushResponse sendExpoMessage(PushNotification pushNotification) throws IOException
    {
        Set<String> tokens = afiliadoRepository.findByCredencial(pushNotification.getCredencial())
                .getTokens().stream().map(Token::getExpoToken).collect(Collectors.toSet());

        List<Message> messages = new ArrayList<>();

        tokens.forEach(token ->
        {
            Message message = buildMessage(pushNotification, token);
            messages.add(message);
        });

        PushTicketResponse expoResponse = ExpoPushClient.sendPushNotifications(messages);

        PushResponse pushResponse = buildPushResponse(pushNotification, expoResponse);

        afiliadoService.savePushAfiliado(pushNotification, pushResponse);

        return pushResponse;

    }

    private PushResponse buildPushResponse(PushNotification pushNotification, PushTicketResponse expoResponse)
    {
        PushResponse pushResponse = new PushResponse();

        List<Ticket> tickets = new ArrayList<>();

        expoResponse.getTickets().forEach(t->
        {
            Ticket ticket = new Ticket(t.getStatus(), t.getId(), pushNotification, t.getDetails(), LocalDateTime.now());
            tickets.add(ticket);
        });

        pushResponse.setTickets(tickets);
        pushResponse.setErrors(expoResponse.getErrors());
        return pushResponse;
    }

    private Message buildMessage(PushNotification pushNotification, String token)
    {
        return new Message.Builder()
                        .to(token)
                        .title(pushNotification.getTitle())
                        .body(pushNotification.getText())
                        .sound("default")
                        .channelId("push")
                        .badge(1)
                        .priority(Priority.HIGH)
                        .build();
    }

    public List<PushNotification> getAll()
    {
        return notificationRepository.findAll();
    }

    public List<PushNotification> getMensajesByAfiliado(String credencial)
    {
        Afiliado afiliado = new Afiliado();
        afiliado.setCredencial(credencial);
        return notificationRepository.findAll((Sort) Example.of(afiliado));
    }
}
