package com.microservice.sendemail.entities;

import org.springframework.stereotype.Component;

@Component
public class EmailEntitiy {

    private String senderEmail;
    private String recipientEmail;
    private String subject;
    private String body;
    private String attachments;

    public EmailEntitiy (){

    }

    public EmailEntitiy(String senderEmail, String recipientEmail, String subject, String body, String attachments) {
        this.senderEmail = senderEmail;
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }
}
