package com.example.springjms;

import com.example.service.FraudDetectService;
import com.example.user.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import java.util.StringTokenizer;

@Component
public class Listener {

    @Autowired
    private Producer producer;

    @Autowired
    FraudDetectService fraudDetectService;

    @JmsListener(destination = "inbound.queue")
    public void receiveMessage(final String receivedmessage) throws JMSException {
            String msg = receivedmessage.trim();
            User receiverUser = new User();
            receiverUser.setAmount(msg.substring(15,19));
            receiverUser.setCardNo(msg.substring(6,14));
            receiverUser.setTransactionId(msg.substring(0,5));
            receiverUser.setTransactionTs(msg.substring(20));
            String card = receiverUser.getCardNo();
            int cardNo = Integer.parseInt(card);
            String amount = receiverUser.getAmount();
            String Id = receiverUser.getTransactionId();
            String ts = receiverUser.getTransactionTs();
        boolean isTransactionDuplicate =  fraudDetectService.isTransactionDuplicateIn10(cardNo);
        String messageData = null;
        if(isTransactionDuplicate == true){
             messageData = String.valueOf(receiverUser.getTransactionId()) + " decision : denied";
        }
        else{
             messageData = String.valueOf(receiverUser.getTransactionId()) + " decision : denied";
        }
        fraudDetectService.savetodb(receiverUser);
          /*  if(jsonMessage instanceof TextMessage) {
                TextMessage textMessage = (TextMessage)jsonMessage;
                messageData = textMessage.getText();
            }*/

            producer.sendMessage("outbound.queue", messageData);
        }


    }
