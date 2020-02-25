package com.example.generatetransactionid.springjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerOutbound {
    @Autowired
    private Producer producer;

    @JmsListener(destination = "enrichTransactionOutbound.queue")
    public void receiveMessage(final String receivedmessage){
        producer.sendMessage("salesOut.queue", receivedmessage);
    }
}
