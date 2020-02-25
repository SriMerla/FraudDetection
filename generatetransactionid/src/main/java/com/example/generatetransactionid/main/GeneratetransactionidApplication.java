package com.example.generatetransactionid.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@ComponentScan(basePackages = "com.example.generatetransactionid")
@SpringBootApplication
public class GeneratetransactionidApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratetransactionidApplication.class, args);
    }

}
