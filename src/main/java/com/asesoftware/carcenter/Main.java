package com.asesoftware.carcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main app Inicia Spring ApplicationContext y carga los beans en el contexto de
 * aplicacion de spring
 *
 * @author adrian
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
