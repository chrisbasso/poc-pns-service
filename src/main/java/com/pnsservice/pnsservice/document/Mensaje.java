package com.pnsservice.pnsservice.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "PushNotification")
public class Mensaje implements Serializable
{

    @Id
    @NotNull
    private Long id;
    private String title;
    private String body;

    public Mensaje(String title, String body)
    {
        this.title = title;
        this.body = body;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getText()
    {
        return body;
    }

    public void setText(String text)
    {
        this.body = text;
    }

}
