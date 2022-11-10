package com.microservice.sendemail.repositories;

import com.microservice.sendemail.entities.SMTPConfigEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMTPConfigRepository extends CrudRepository <SMTPConfigEntity, Integer>{
    SMTPConfigEntity findSMTPConfigEntityBySenderEmail(String senderEmail);
}
