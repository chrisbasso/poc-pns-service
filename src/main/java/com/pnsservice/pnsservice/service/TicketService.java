package com.pnsservice.pnsservice.service;

import com.pnsservice.pnsservice.document.Ticket;
import com.pnsservice.pnsservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService
{
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getTicketsByAfiliado(String credencial)
    {
        return ticketRepository.findAllByCredencial(credencial);
    }

    public List<Ticket> saveAll(List<Ticket> tickets)
    {
        return ticketRepository.saveAll(tickets);
    }

}
