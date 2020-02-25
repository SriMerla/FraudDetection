package com.example.customercontrols.springJms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerOutbound {
    @Autowired
    Producer producer;
    @JmsListener(destination = "fraudDetectOutbound.queue")
    public void receiveMessage(final String receivedmessage){
        producer.sendMessage("enrichTransactionOutbound.queue",receivedmessage);
    }
}
