package com.lva.musicserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(Main.class,args);
    }
}
