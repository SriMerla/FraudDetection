package com.example.customercontrols.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;


@ComponentScan(basePackages = "com.example.customercontrols")
@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
@EnableJms
public class CustomercontrolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomercontrolsApplication.class, args);
    }

}
