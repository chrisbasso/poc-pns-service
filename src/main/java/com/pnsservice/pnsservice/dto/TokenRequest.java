package com.pnsservice.pnsservice.dto;

import com.pnsservice.pnsservice.document.Token;

public class TokenRequest
{

    private String credencial;
    private Token tokens;

    public Token getTokens() {
        return tokens;
    }

    public void setTokens(Token tokens) {
        this.tokens = tokens;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public Token getToken() {
        return tokens;
    }

}
