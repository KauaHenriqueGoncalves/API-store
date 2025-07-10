package com.program.webspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSpringBootApplication.class, args);
        System.out.println("Spring web: http://localhost:8080/");
        System.out.println("Console H2: http://localhost:8080/h2-console/");
    }

}
