package com.pnsservice.pnsservice.service;

import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.document.Mensaje;
import com.pnsservice.pnsservice.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeService
{
    @Autowired
    private MensajeRepository mensajeRepository;

    public Mensaje create(String title, String text, Afiliado addressee)
    {
        return mensajeRepository.save(new Mensaje(title, text, addressee));
    }

    public List<Mensaje> getAll()
    {
        return mensajeRepository.findAll();
    }

    public List<Mensaje> getMensajesByAfiliado(String credencial)
    {
        Afiliado afiliado = new Afiliado();
        afiliado.setCredencial(credencial);
        return mensajeRepository.findAll((Sort) Example.of(afiliado));
    }
}
