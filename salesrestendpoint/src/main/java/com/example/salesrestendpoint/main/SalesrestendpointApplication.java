package com.example.salesrestendpoint.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@ComponentScan(basePackages = "com.example.salesrestendpoint")
@SpringBootApplication
public class SalesrestendpointApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesrestendpointApplication.class, args);
    }

}
