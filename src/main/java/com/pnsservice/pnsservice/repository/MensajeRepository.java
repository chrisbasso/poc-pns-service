package com.pnsservice.pnsservice.repository;

import com.pnsservice.pnsservice.document.PushNotification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MensajeRepository extends MongoRepository<PushNotification, Serializable>
{

}
