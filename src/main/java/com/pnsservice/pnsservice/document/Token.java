package com.pnsservice.pnsservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "Token")
public class Token implements Serializable
{

    private String type;
    private String nativeToken;
    private String expoToken;

    public Token(String type, String nativeToken, String expoToken)
    {
        this.type = type;
        this.nativeToken = nativeToken;
        this.expoToken = expoToken;
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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token that = (Token) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(nativeToken, that.nativeToken) &&
                Objects.equals(expoToken, that.expoToken);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(type, nativeToken, expoToken);
    }
}
