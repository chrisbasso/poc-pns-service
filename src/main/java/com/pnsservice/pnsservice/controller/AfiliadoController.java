package com.pnsservice.pnsservice.controller;

import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.service.AfiliadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "afiliado")
public class AfiliadoController
{

    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping(value="/{credencial}")
    public ResponseEntity<Object> getAfiliado(@PathVariable String credencial)
    {
        Afiliado afiliado = afiliadoService.getByCredencial(credencial);
        return new ResponseEntity<>(afiliado, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        List<Afiliado> afiliados = afiliadoService.getAll();
        return new ResponseEntity<>(afiliados, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{credencial}")
    public void deleteAfiliado(@PathVariable String credencial)
    {
        afiliadoService.deleteAfiliado(credencial);
    }

}
