package com.pnsservice.pnsservice.controller;

import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "token")
public class TokenController
{

    @Autowired
    private TokenService tokenService;

    @GetMapping(value = "/{credencial}")
    public ResponseEntity<Object> getTokensByAfiliado(@PathVariable String credencial)
    {
        List<Token> tokens = tokenService.getTokensByAfiliado(credencial);
        return new ResponseEntity<>(tokens, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addToken(@RequestBody Token tokenRequest)
    {
        Token token = tokenService.addToken(tokenRequest);
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteToken(@RequestBody Token token)
    {
        tokenService.deleteToken(token);
        return new ResponseEntity<>("Token Eliminado", HttpStatus.OK);
    }

}
