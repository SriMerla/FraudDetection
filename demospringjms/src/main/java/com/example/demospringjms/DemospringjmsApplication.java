package com.example.demospringjms;

import com.example.springjms.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@ComponentScan(basePackages = "com.example")
@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
@EnableJms
public class DemospringjmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemospringjmsApplication.class, args);
    }
}

