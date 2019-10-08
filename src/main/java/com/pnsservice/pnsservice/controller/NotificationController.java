package com.pnsservice.pnsservice.controller;

import com.google.api.core.ApiFuture;
import com.google.firebase.messaging.BatchResponse;
import com.pnsservice.pnsservice.document.PushNotification;
import com.pnsservice.pnsservice.dto.PushResponse;
import com.pnsservice.pnsservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "notification")
public class NotificationController
{

    @Autowired
    private NotificationService notificationService;

    @PostMapping(value="/sendFireBase")
    public ResponseEntity<Object> sendFireBase(@RequestBody PushNotification pushNotificationRequest)
    {
        ApiFuture<BatchResponse> mensaje = notificationService.sendFireBaseMessage(pushNotificationRequest);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping(value="/send")
    public ResponseEntity<Object> sendExpo(@RequestBody PushNotification pushNotificationRequest) throws IOException
    {
        PushResponse pushResponse = notificationService.sendExpoMessage(pushNotificationRequest);
        return new ResponseEntity<>(pushResponse, HttpStatus.OK);
    }

}
