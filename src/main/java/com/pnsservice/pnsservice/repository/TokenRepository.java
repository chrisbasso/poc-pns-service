package com.pnsservice.pnsservice.repository;

import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.dto.TokenRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface TokenRepository extends MongoRepository<Token, Serializable>
{
    Token findByExpoToken(String expoToken);

    List<Token> findAllByCredencial(String credencial);
}
