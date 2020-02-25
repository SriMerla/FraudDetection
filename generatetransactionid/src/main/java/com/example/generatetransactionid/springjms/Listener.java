package com.example.generatetransactionid.springjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class Listener {

    @Autowired
    private Producer producer;

    @JmsListener(destination = "salesIn.queue")
    public void receiveMessage(final String receivedmessage) throws ParseException {
        /*User user = new User();
        user.setCardNo(receivedmessage.substring(0, 8));
        user.setAmount(receivedmessage.substring(9, 15));
        user.setTransactionTs(receivedmessage.substring(16));
        String ucard =  user.getCardNo();
        String uname = jdbcGenerateTransactionIdRepo.findByUserName(ucard);
        String uniqueId= null;
        if(uname != null){
            uniqueId = generateTransactionId.generateUniqueId();
        }
        else{

             uniqueId = "TransactionId is not generated";

        }
*/
        producer.sendMessage("generatedTranId.queue", receivedmessage);
    }
}
