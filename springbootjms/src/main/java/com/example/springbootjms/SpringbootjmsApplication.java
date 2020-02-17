package com.example.springbootjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
@ComponentScan(basePackages = "com.example.springbootjms")
@EnableJms
public class SpringbootjmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootjmsApplication.class, args);
    }


    @Bean

    public JmsListenerContainerFactory<?> myFactory(

            ConnectionFactory connectionFactory,

            DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        configurer.configure(factory, connectionFactory);

        return factory;

    }

    // Serialize message content to json using TextMessage

    @Bean

    public MessageConverter jacksonJmsMessageConverter() {

        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

        converter.setTargetType(MessageType.TEXT);

        converter.setTypeIdPropertyName("_type");

        return converter;

    }
}
