package com.pnsservice.pnsservice.controller;

import com.pnsservice.pnsservice.document.Ticket;
import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "mensaje")
public class TicketControlller {

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/{credencial}")
    public ResponseEntity<Object> getTicketsByAfiliado(@PathVariable String credencial)
    {
        List<Ticket> tickets = ticketService.getTicketsByAfiliado(credencial);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

}
