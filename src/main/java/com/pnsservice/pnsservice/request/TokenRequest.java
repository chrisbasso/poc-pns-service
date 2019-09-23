package com.pnsservice.pnsservice.request;

public class TokenRequest {

    private String credencial;
    private String token;

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
