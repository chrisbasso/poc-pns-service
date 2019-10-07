package com.pnsservice.pnsservice.service;

import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.document.PushNotification;
import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.dto.PushResponse;
import com.pnsservice.pnsservice.repository.AfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoService
{

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    public Afiliado create(String credencial)
    {
        return afiliadoRepository.save(new Afiliado(credencial));
    }

    public List<Afiliado> getAll()
    {
        return afiliadoRepository.findAll();
    }

    public Afiliado getByCredencial(String credencial)
    {
        return afiliadoRepository.findByCredencial(credencial);
    }

    public Afiliado addToken(String credencial, Token token)
    {
        Optional<Afiliado> afiliado = Optional.ofNullable(afiliadoRepository.findByCredencial(credencial));
        if(afiliado.isPresent())
        {
            afiliado.get().addToken(token);
            return afiliadoRepository.save(afiliado.get());
        }else{
            Afiliado newAfiliado = this.create(credencial);
            newAfiliado.addToken(token);
            return afiliadoRepository.save(newAfiliado);
        }
    }

    public void savePushAfiliado(PushNotification pushNotification, PushResponse pushResponse) {
        Afiliado afiliado = afiliadoRepository.findByCredencial(pushNotification.getCredencial());
        afiliado.getPushNotifications().add(pushResponse);
        afiliadoRepository.save(afiliado);
    }

    public void deleteAfiliado(String credencial)
    {
        afiliadoRepository.deleteAfiliadoByCredencial(credencial);
    }

    public Afiliado deleteToken(Token tokens)
    {
        Optional<Afiliado> afiliado = Optional.ofNullable(afiliadoRepository.findByTokensContains(tokens));
        if(afiliado.isPresent())
        {
            afiliado.get().getTokens().remove(tokens);
            return afiliadoRepository.save(afiliado.get());
        }
        return null;
    }
}
