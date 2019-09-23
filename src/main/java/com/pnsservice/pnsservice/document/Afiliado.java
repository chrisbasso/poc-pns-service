package com.pnsservice.pnsservice.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection = "Afiliado")
public class Afiliado implements Serializable {

    @Id
    @NotNull
    private Long id;

    private String credencial;

    private Set<String> tokens;

    public Afiliado() {}

    public Afiliado(String credencial)
    {
        this.credencial = credencial;
        this.tokens = new HashSet<>();
    }

    public String getCredencial()
    {
        return credencial;
    }

    public void setCredencial(String credencial)
    {
        this.credencial = credencial;
    }

    public Set<String> getTokens()
    {
        return tokens;
    }

    public void setTokens(Set<String> tokens)
    {
        this.tokens = tokens;
    }

    public void addToken(String token)
    {
        this.tokens.add(token);
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
