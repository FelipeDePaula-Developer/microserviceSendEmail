package com.microservice.sendemail.controllers;

import com.microservice.sendemail.entities.EmailEntitiy;
import com.microservice.sendemail.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/email/send")
    public boolean receiveEmailRequest(@RequestBody EmailEntitiy email){
         emailService.sendEmail(email);
         return true;
    }
}
