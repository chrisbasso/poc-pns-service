package com.pnsservice.pnsservice.controller;

import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.dto.TokenRequest;
import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.service.AfiliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "dispositivoAfiliado")
public class DispositivoAfiliadoController
{

    @Autowired
    private AfiliadoService afiliadoService;

    @PostMapping
    public ResponseEntity<Object> addToken(@RequestBody TokenRequest request)
    {
        Afiliado afiliado = afiliadoService.addToken(request.getCredencial(), request.getToken());
        return new ResponseEntity<>(afiliado, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteToken(@RequestBody Token token)
    {
        Afiliado afiliado = afiliadoService.deleteToken(token);
        return new ResponseEntity<>(afiliado, HttpStatus.OK);
    }

}
