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

    private boolean verifyEmail(String emailRecipient) {
        boolean flag;
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        Pattern pattern = Pattern.compile(regex);
        flag = pattern.matcher(emailRecipient).matches();
        return flag;
    }

    public boolean sendEmail(EmailEntitiy email) {
        if (!verifyEmail(email.getRecipientEmail())) {
            return false;
        }
        Properties props = System.getProperties();
        SMTPConfigEntity SMTPConfig = smtpConfigRepository.findSMTPConfigEntityBySenderEmail(email.getSenderEmail());
        final String fromEmail = SMTPConfig.getSenderEmail();
        final String password = SMTPConfig.getPassword();

        props.put("mail.smtp.host", SMTPConfig.getHost());
        props.put("mail.smtp.port", SMTPConfig.getPortSSL());
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });
//        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SMTPConfig.getSenderEmail()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipientEmail()));
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            Transport.send(message);
        } catch (MessagingException mex) {
            return false;
        }
        return true;
    }
}
