package com.pnsservice.pnsservice.repository;

import com.pnsservice.pnsservice.document.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Serializable>
{
    List<Ticket> findAllByCredencial(String credencial);
}
