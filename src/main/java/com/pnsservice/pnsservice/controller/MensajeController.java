package com.pnsservice.pnsservice.controller;

import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.document.Mensaje;
import com.pnsservice.pnsservice.request.TokenRequest;
import com.pnsservice.pnsservice.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @PostMapping(value="/addMensaje")
    public ResponseEntity<Object> addToken(@RequestBody Mensaje mensajeRequest)
    {
        Mensaje mensaje = mensajeService.create(mensajeRequest.getTitle(), mensajeRequest.getText(), mensajeRequest.getAddressee());
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

}
