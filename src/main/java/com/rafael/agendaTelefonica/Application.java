package com.rafael.agendaTelefonica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Bean
    public CommandLineRunner runner(){
        return args -> {
            System.out.println("Aplicação iniciada");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
