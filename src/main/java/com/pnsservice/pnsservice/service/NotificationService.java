package com.pnsservice.pnsservice.service;

import com.google.api.core.ApiFuture;
import com.google.firebase.messaging.*;
import com.kinoroy.expo.push.*;
import com.kinoroy.expo.push.Message;
import com.pnsservice.pnsservice.document.Mensaje;
import com.pnsservice.pnsservice.document.Ticket;
import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.dto.PushRequest;
import com.pnsservice.pnsservice.dto.PushResponse;
import com.pnsservice.pnsservice.exceptions.AfiliadoInexistenteException;
import com.pnsservice.pnsservice.repository.NotificationRepository;
import com.pnsservice.pnsservice.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
    private TokenRepository tokenRepository;

    @Autowired
    private TicketService ticketService;


    public ApiFuture<BatchResponse> sendFireBaseMessage(PushRequest pushRequest)
    {
        Set<String> tokens = tokenRepository.findAllByCredencial(pushRequest.getCredencial())
                .stream().map(Token::getNativeToken).collect(Collectors.toSet());

        MulticastMessage messages = MulticastMessage.builder()
                .addAllTokens(tokens)
                .setNotification(new Notification(pushRequest.getTitle(), pushRequest.getBody()))
                .setAndroidConfig(AndroidConfig.builder()
                        .setNotification(AndroidNotification.builder().setTitle(pushRequest.getTitle())
                                .setBody(pushRequest.getBody())
                                .build())
                        .build())
                .build();

        return FirebaseMessaging.getInstance().sendMulticastAsync(messages);
    }

    public PushResponse sendExpoMessage(PushRequest pushRequest) throws IOException, AfiliadoInexistenteException {

        Set<String> tokens = tokenRepository.findAllByCredencial(pushRequest.getCredencial())
                .stream().map(Token::getExpoToken).collect(Collectors.toSet());

        if(tokens.isEmpty()){
            throw new AfiliadoInexistenteException("Afiliado no registrado para recibir notificaciones", HttpStatus.OK);
        }

        List<Message> messages = new ArrayList<>();

        tokens.forEach(token ->
        {
            Message message = buildMessage(pushRequest, token);
            messages.add(message);
        });

        PushTicketResponse expoResponse = ExpoPushClient.sendPushNotifications(messages);

        PushResponse pushResponse = buildPushResponse(pushRequest, expoResponse);

        ticketService.saveAll(pushResponse.getTickets());

        return pushResponse;

    }

    private PushResponse buildPushResponse(PushRequest pushRequest, PushTicketResponse expoResponse)
    {
        PushResponse pushResponse = new PushResponse();
        Mensaje mensaje = new Mensaje(pushRequest.getTitle(), pushRequest.getBody());

        List<Ticket> tickets = new ArrayList<>();

        expoResponse.getTickets().forEach(t->
        {
            Ticket ticket = new Ticket(pushRequest.getCredencial(),t.getStatus(), t.getId(), mensaje, t.getDetails(), LocalDateTime.now());
            tickets.add(ticket);
        });

        pushResponse.setTickets(tickets);
        pushResponse.setErrors(expoResponse.getErrors());
        return pushResponse;
    }

    private Message buildMessage(PushRequest pushRequest, String token)
    {
        return new Message.Builder()
                        .to(token)
                        .title(pushRequest.getTitle())
                        .body(pushRequest.getBody())
                        .sound("default")
                        .channelId("push")
                        .badge(1)
                        .priority(Priority.HIGH)
                        .build();
    }

    public List<Mensaje> getAll()
    {
        return notificationRepository.findAll();
    }

}
