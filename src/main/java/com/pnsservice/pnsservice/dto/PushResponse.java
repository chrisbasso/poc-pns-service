package com.pnsservice.pnsservice.dto;

import com.kinoroy.expo.push.ExpoError;
import com.pnsservice.pnsservice.document.Ticket;

import java.util.List;

public class PushResponse {

    private List<Ticket> tickets;
    private List<ExpoError> errors;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<ExpoError> getErrors() {
        return errors;
    }

    public void setErrors(List<ExpoError> errors) {
        this.errors = errors;
    }
}
