package com.microservice.sendemail.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    EmailService emailService;
    @BeforeEach
    void setUp() {
        emailService = new EmailService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void verifyEmailSuccess() {
        assertAll(
                () -> assertTrue(emailService.verifyEmail("test2000@gmail.com")),
                () -> assertTrue(emailService.verifyEmail("test2000@gmail.com.br")),
                () -> assertTrue(emailService.verifyEmail("t_e_s_t2000@gmail.com.br")),
                () -> assertTrue(emailService.verifyEmail("t_e_s.ttes2000@gmail.com.br")),
                () -> assertFalse(emailService.verifyEmail("aaaaaaaaaa"))
        );
    }

    @Test
    void sendEmail() {
    }

}