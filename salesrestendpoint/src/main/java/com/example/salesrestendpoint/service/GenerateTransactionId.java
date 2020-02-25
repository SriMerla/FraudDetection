package com.example.salesrestendpoint.service;

import com.example.salesrestendpoint.TransactionId.TransactionId;
import com.example.salesrestendpoint.springjms.ListenerOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class GenerateTransactionId {
   Map<String, String> resMap ;
    @Autowired
    TransactionId transactionId;

    public String generateUniqueId(){
        UUID uniqueKey = UUID.randomUUID();
        String key = uniqueKey.toString();
        transactionId.setTransactionId(key);
        return key;
    }


    public String generateTransactionTS(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       String ts =  timestamp.toString();
        return ts;
    }




}
