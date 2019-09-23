package com.pnsservice.pnsservice.service;

import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.repository.AfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public Afiliado addToken(String credencial, String token)
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

    public void deleteAfiliado(String credencial)
    {
        afiliadoRepository.deleteAfiliadoByCredencial(credencial);
    }

    public Afiliado deleteToken(String token)
    {
        Optional<Afiliado> afiliado = Optional.ofNullable(afiliadoRepository.findByTokensContains(token));
        if(afiliado.isPresent())
        {
            afiliado.get().getTokens().remove(token);
            return afiliadoRepository.save(afiliado.get());
        }
        return null;
    }
}
