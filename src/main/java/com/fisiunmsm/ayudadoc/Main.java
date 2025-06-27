package com.fisiunmsm.ayudadoc;

import java.util.Locale;

import com.fisiunmsm.ayudadoc.shared.helper.AyudocLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.forLanguageTag("ES"));

        // Log inicial
        AyudocLog.getInstance().log("debug", "Iniciando Spring Boot para Ayuda al Docente");

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        Environment env = context.getEnvironment();
        String puerto = env.getProperty("local.server.port", "8080");

        // Registra el puerto en el log
        AyudocLog.getInstance().info("Servidor iniciado en el puerto: " + puerto);
    }
}
