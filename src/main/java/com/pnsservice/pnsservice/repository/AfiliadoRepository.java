package com.pnsservice.pnsservice.repository;

import com.pnsservice.pnsservice.document.Afiliado;
import com.pnsservice.pnsservice.document.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AfiliadoRepository extends MongoRepository<Afiliado, Serializable>
{

    Afiliado findByCredencial(String credencial);

    void deleteAfiliadoByCredencial(String credencial);

    Afiliado findByTokensContains(Token tokens);

}
