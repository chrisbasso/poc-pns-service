package com.pnsservice.pnsservice.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "Mensaje")
public class Mensaje implements Serializable
{

    @Id
    @NotNull
    private Long id;
    private String title;
    private String text;
    private Afiliado addressee;

    public Mensaje(String title, String text, Afiliado addressee)
    {
        this.title = title;
        this.text = text;
        this.addressee = addressee;
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

    public Afiliado getAddressee()
    {
        return addressee;
    }

    public void setAddressee(Afiliado addressee)
    {
        this.addressee = addressee;
    }
}
