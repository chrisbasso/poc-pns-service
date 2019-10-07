package com.pnsservice.pnsservice.document;

import com.pnsservice.pnsservice.dto.PushResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Document(collection = "Afiliado")
public class Afiliado implements Serializable
{

    @Id
    @NotNull
    private String id;

    private String credencial;

    private Set<Token> tokens;

    private List<PushResponse> pushNotifications;

    public Afiliado() {}

    public Afiliado(String credencial)
    {
        this.credencial = credencial;
        this.tokens = new HashSet<>();
        this.pushNotifications = new ArrayList<>();
    }

    public String getCredencial()
    {
        return credencial;
    }

    public void setCredencial(String credencial)
    {
        this.credencial = credencial;
    }

    public Set<Token> getTokens()
    {
        return tokens;
    }

    public void setTokens(Set<Token> tokens)
    {
        this.tokens = tokens;
    }

    public void addToken(Token token)
    {
        this.tokens.add(token);
    }


    public List<PushResponse> getPushNotifications() {
        return pushNotifications;
    }

    public void setPushNotifications(List<PushResponse> pushNotifications) {
        this.pushNotifications = pushNotifications;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Afiliado afiliado = (Afiliado) o;
        return Objects.equals(credencial, afiliado.credencial);

    }

    @Override
    public int hashCode()
    {
        return Objects.hash(credencial);
    }
}
