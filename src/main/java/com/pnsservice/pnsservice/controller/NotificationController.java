package com.pnsservice.pnsservice.controller;

import com.google.api.core.ApiFuture;
import com.google.firebase.messaging.BatchResponse;
import com.pnsservice.pnsservice.document.Mensaje;
import com.pnsservice.pnsservice.dto.PushRequest;
import com.pnsservice.pnsservice.dto.PushResponse;
import com.pnsservice.pnsservice.exceptions.AfiliadoInexistenteException;
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
    public ResponseEntity<Object> sendFireBase(@RequestBody PushRequest pushRequest)
    {
        ApiFuture<BatchResponse> mensaje = notificationService.sendFireBaseMessage(pushRequest);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping(value="/send")
    public ResponseEntity<Object> sendExpo(@RequestBody PushRequest pushRequest) throws IOException
    {
        PushResponse pushResponse;
        try {
            pushResponse = notificationService.sendExpoMessage(pushRequest);
        } catch (AfiliadoInexistenteException e) {
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }
        return new ResponseEntity<>(pushResponse, HttpStatus.OK);
    }

}
