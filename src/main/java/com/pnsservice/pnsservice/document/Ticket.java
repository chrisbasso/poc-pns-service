package com.pnsservice.pnsservice.document;

import com.kinoroy.expo.push.Details;
import com.kinoroy.expo.push.Status;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Ticket")
public class Ticket
{

    private Status status;
    private String id;
    private Mensaje message;
    private Details details;
    private LocalDateTime time;
    private String credencial;

    public Ticket(String credencial, Status status, String id, Mensaje message, Details details, LocalDateTime time)
    {
        this.credencial = credencial;
        this.status = status;
        this.id = id;
        this.message = message;
        this.details = details;
        this.time = time;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mensaje getMessage() {
        return message;
    }

    public void setMessage(Mensaje message) {
        this.message = message;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
