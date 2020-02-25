package com.example.salesrestendpoint.springjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String queueName, final String msg) {

        jmsTemplate.send(queueName, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage();
                message.setText(msg);
                return message;
            }
        });

    }
}
