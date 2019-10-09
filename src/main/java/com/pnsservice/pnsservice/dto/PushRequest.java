package com.pnsservice.pnsservice.dto;


import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;

public class PushRequest
{

    @Id
    @NotNull
    private Long id;
    private String title;
    private String body;
    private String credencial;

    public PushRequest(String title, String body, String credencial)
    {
        this.title = title;
        this.body = body;
        this.credencial = credencial;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
