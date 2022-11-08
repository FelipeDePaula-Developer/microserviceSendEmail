package com.microservice.sendemail.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "smtp_config")
public class SMTPConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_smtp;

    @NotBlank
    private String host;
    @NotBlank
    private String senderName;
    @NotBlank
    private String senderEmail;
    @NotBlank
    private String password;
    @NotBlank
    private String portTSL;
    @NotBlank
    private String portSSL;

    public SMTPConfigEntity(){

    }

    public SMTPConfigEntity(String host, String senderName, String senderEmail, String password, String portTSL, String portSSL) {
        this.host = host;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.password = password;
        this.portTSL = portTSL;
        this.portSSL = portSSL;
    }

    public Integer getId_user() {
        return id_smtp;
    }

    public void setId_user(Integer id_smtp) {
        this.id_smtp = id_smtp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortTSL() {
        return portTSL;
    }

    public void setPortTSL(String portTSL) {
        this.portTSL = portTSL;
    }

    public String getPortSSL() {
        return portSSL;
    }

    public void setPortSSL(String portSSL) {
        this.portSSL = portSSL;
    }

}
