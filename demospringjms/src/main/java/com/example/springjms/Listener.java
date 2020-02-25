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

import java.text.ParseException;
import java.util.StringTokenizer;

@Component
public class Listener {

    @Autowired
    private Producer producer;

    @Autowired
    FraudDetectService fraudDetectService;

    @JmsListener(destination = "fraudDetect.queue")
    public void receiveMessage(final String receivedmessage) throws ParseException {
            String msg = receivedmessage.trim();
            User receiverUser = new User();
        String uname[] = receivedmessage.split(" , ");
        for(int i=0; i<= uname.length-1; i++){
            if(i == 0){
                receiverUser.setTransactionId(uname[i]);
            }
            if(i==1){

                receiverUser.setCardNo(uname[i]);
            }
            if(i==2)
            {
                receiverUser.setAmount(uname[i]);
            }
            else{
                receiverUser.setTransactionTs(uname[i]);
            }
        }
        String card = receiverUser.getCardNo();

           /* receiverUser.setAmount(msg.substring(15));
            receiverUser.setCardNo(msg.substring(6,14));
            receiverUser.setTransactionId(msg.substring(0,5));

            String card = receiverUser.getCardNo();
            int cardNo = Integer.parseInt(card);
            String amount = receiverUser.getAmount();
            String Id = receiverUser.getTransactionId();*/

        boolean isTransactionDuplicate =  fraudDetectService.isTransactionDuplicateIn10(card);
        String messageData = null;
        if(isTransactionDuplicate == true){
             messageData = String.valueOf(receiverUser.getTransactionId()) + " decision:denied";
        }
        else{
             messageData = String.valueOf(receiverUser.getTransactionId()) + " decision:Success";
        }
        fraudDetectService.savetodb(receiverUser);
          /*  if(jsonMessage instanceof TextMessage) {
                TextMessage textMessage = (TextMessage)jsonMessage;
                messageData = textMessage.getText();
            }*/

            producer.sendMessage("fraudDetectOutbound.queue", messageData);
        }


    }
