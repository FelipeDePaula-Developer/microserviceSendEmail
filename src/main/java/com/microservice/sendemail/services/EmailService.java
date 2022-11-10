package com.microservice.sendemail.services;

//import com.microservice.sendemail.entities.EmailEntitiy;

import com.microservice.sendemail.entities.EmailEntitiy;
import com.microservice.sendemail.entities.SMTPConfigEntity;
import com.microservice.sendemail.repositories.SMTPConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Pattern;

@Component
public class EmailService {

    @Autowired
    SMTPConfigRepository smtpConfigRepository;

    private boolean verifyEmail(String emailSender, String emailRecipient) {
        boolean flag;
        String regex = "^[A-Za-z0-9+_.-] +@ (.+)$";
        Pattern pattern = Pattern.compile(regex);
        flag = pattern.matcher(emailSender).matches();
        flag = pattern.matcher(emailRecipient).matches();
        return flag;
    }

    public boolean sendEmail(EmailEntitiy email) {
        Properties prop = System.getProperties();
        System.out.println(email.getSenderEmail());
        SMTPConfigEntity SMTPConfig = smtpConfigRepository.findSMTPConfigEntityBySenderEmail(email.getSenderEmail());
        final String fromEmail = SMTPConfig.getSenderEmail();
        final String password = SMTPConfig.getPassword();

        prop.put("mail.smtp.host", SMTPConfig.getHost());
        prop.put("mail.smtp.port", SMTPConfig.getPortSSL());
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SMTPConfig.getSenderEmail()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipientEmail()));
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            Transport.send(message);
        }catch (MessagingException mex){
            mex.printStackTrace();
        }
//        if (!verifyEmail(email.getSenderEmail(), email.getRecipientEmail())){
//            return false;
//        }
//
        return true;
    }
}
