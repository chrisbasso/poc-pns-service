package com.pnsservice.pnsservice.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Document(collection = "Token")
public class Token implements Serializable
{
    @Id
    @NotNull
    private String id;

    private String credencial;
    private String type;
    private String nativeToken;
    private String expoToken;

    public Token() { }

    public Token(String credencial, String type, String nativeToken, String expoToken) {
        this.credencial = credencial;
        this.type = type;
        this.nativeToken = nativeToken;
        this.expoToken = expoToken;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNativeToken() {
        return nativeToken;
    }

    public void setNativeToken(String nativeToken) {
        this.nativeToken = nativeToken;
    }

    public String getExpoToken() {
        return expoToken;
    }

    public void setExpoToken(String expoToken) {
        this.expoToken = expoToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return
                Objects.equals(credencial, token.credencial) &&
                Objects.equals(type, token.type) &&
                Objects.equals(nativeToken, token.nativeToken) &&
                Objects.equals(expoToken, token.expoToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, credencial, type, nativeToken, expoToken);
    }
}
