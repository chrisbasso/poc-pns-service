package com.pnsservice.pnsservice.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "PushNotification")
public class PushNotification implements Serializable
{

    @Id
    @NotNull
    private Long id;
    private String title;
    private String text;
    private String credencial;

    public PushNotification(String title, String text, String credencial)
    {
        this.title = title;
        this.text = text;
        this.credencial = credencial;
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
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }
}
