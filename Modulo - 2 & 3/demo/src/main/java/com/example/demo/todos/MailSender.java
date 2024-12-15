package com.example.demo.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar(String mensagem){
        System.out.println("Enviar email: " + mensagem );
    }
}
