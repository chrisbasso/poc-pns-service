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
    private PushNotification message;
    private Details details;
    private LocalDateTime time;

    public Ticket(Status status, String id, PushNotification message, Details details, LocalDateTime time)
    {
        this.status = status;
        this.id = id;
        this.message = message;
        this.details = details;
        this.time = time;
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

    public PushNotification getMessage() {
        return message;
    }

    public void setMessage(PushNotification message) {
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
