package com.pnsservice.pnsservice.repository;

import com.pnsservice.pnsservice.document.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface NotificationRepository extends MongoRepository<Mensaje, Serializable>
{

}
