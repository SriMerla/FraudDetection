package com.example.salesrestendpoint.service;

import com.example.salesrestendpoint.TransactionId.TransactionId;
import com.example.salesrestendpoint.springjms.ListenerOutbound;
import com.example.salesrestendpoint.springjms.Producer;
import com.sun.corba.se.spi.ior.IdentifiableFactoryFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;


@RestController
public class SalesController {

    @Autowired
    Producer producer;

    @Autowired
    ResultMap resultMap;

    @Autowired
    GenerateTransactionId generateTransactionId;



    public Map<String, DeferredResult> transactoinIdDeferredResultMap = new HashMap<>();

    @GetMapping("/{card}")
    public DeferredResult<ResponseEntity<String>>  sales(@PathVariable("card") String card, @RequestParam("amount") float amount){


        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult<>();
        String transactionId = generateTransactionId.generateUniqueId();

        String timeStamp = generateTransactionId.generateTransactionTS();

        transactoinIdDeferredResultMap.put(transactionId, deferredResult);
        System.out.println("card swiped, TransactionId = "+ transactionId + " cardNo = " + card + " , amount - " + amount + ", timeStamp : " + timeStamp);

      producer.sendMessage("salesIn.queue", transactionId + " , " + card + " , " + amount + " , " + timeStamp );

        return deferredResult;
    }
}
