package com.microservice.sendemail.services;

//import com.microservice.sendemail.entities.EmailEntitiy;

import java.util.regex.Pattern;

public class EmailService {

    private boolean verifyEmail(String emailSender, String emailRecipient){
        boolean flag;
        String regex = "^[A-Za-z0-9+_.-] +@ (.+)$";
        Pattern pattern = Pattern.compile(regex);
        flag = pattern.matcher(emailSender).matches();
        flag = pattern.matcher(emailRecipient).matches();
        return flag;
    }

//    public boolean sendEmail(EmailEntitiy email){
//        if (!verifyEmail(email.getSenderEmail(), email.getRecipientEmail())){
//            return false;
//        }
//
//        return true;
//    }
}
