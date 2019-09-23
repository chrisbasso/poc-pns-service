package com.pnsservice.pnsservice.repository;

import com.pnsservice.pnsservice.document.Afiliado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface AfiliadoRepository extends MongoRepository<Afiliado, Serializable>
{

    Afiliado findByCredencial(String credencial);

    void deleteAfiliadoByCredencial(String credencial);

    Afiliado findByTokensContains(String token);

}
