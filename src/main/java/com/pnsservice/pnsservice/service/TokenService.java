package com.pnsservice.pnsservice.service;

import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.repository.NotificationRepository;
import com.pnsservice.pnsservice.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService
{
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private TokenRepository tokenRepository;

    public List<Token> getTokensByAfiliado(String credencial){
        return tokenRepository.findAllByCredencial(credencial);
    }

    public Token getByExpoToken(String expoToken){
        return tokenRepository.findByExpoToken(expoToken);
    }

    public Token addToken(Token token){
        if(tokenRepository.exists(Example.of(token))){
            return token;
        }
        Token oldToken = tokenRepository.findByExpoToken(token.getExpoToken());
        if(oldToken != null){
            oldToken.setNativeToken(token.getNativeToken());
            return tokenRepository.save(oldToken);
        }
        return tokenRepository.save(token);
    }

    public void deleteToken(Token token){
        tokenRepository.delete(token);
    }
}

