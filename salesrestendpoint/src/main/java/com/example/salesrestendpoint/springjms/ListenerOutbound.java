package com.example.salesrestendpoint.springjms;


import com.example.salesrestendpoint.TransactionId.TransactionId;
import com.example.salesrestendpoint.service.GenerateTransactionId;
import com.example.salesrestendpoint.service.ResultMap;
import com.example.salesrestendpoint.service.SalesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerOutbound {

    @Autowired
    private Producer producer;

    @Autowired
    ResultMap resultMap;

    @Autowired
    SalesController salesController;


    @JmsListener(destination = "salesOut.queue")
    public void receiveMessage(final String receivedmessage){

        System.out.println(receivedmessage);
        String transactionId = receivedmessage.substring(0, 36);
        String msg = receivedmessage.substring(37);
        salesController.transactoinIdDeferredResultMap.get(transactionId).setResult(ResponseEntity.status(HttpStatus.OK).body(msg));

    }

}
