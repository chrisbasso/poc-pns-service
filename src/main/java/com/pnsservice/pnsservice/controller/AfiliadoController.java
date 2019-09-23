package com.pnsservice.pnsservice.controller;

import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.request.TokenRequest;
import com.pnsservice.pnsservice.service.AfiliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AfiliadoController
{

    @Autowired
    private AfiliadoService afiliadoService;

    @PostMapping(value="/addToken")
    public ResponseEntity<Object> addToken(@RequestBody TokenRequest request)
    {
        Afiliado afiliado = afiliadoService.addToken(request.getCredencial(), request.getToken());
        return new ResponseEntity<>(afiliado, HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteToken")
    public ResponseEntity<Object> deleteToken(@RequestBody String token)
    {
        Afiliado afiliado = afiliadoService.deleteToken(token);
        return new ResponseEntity<>(afiliado, HttpStatus.OK);
    }

    @GetMapping(value="/getAfiliado/{credencial}")
    public ResponseEntity<Object> getAfiliado(@PathVariable String credencial)
    {
        Afiliado afiliado = afiliadoService.getByCredencial(credencial);
        return new ResponseEntity<>(afiliado, HttpStatus.OK);
    }

}
