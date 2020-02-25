package com.example.salesrestendpoint.TransactionId;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TransactionId {

    private String transactionId;

    public TransactionId(String transactionId) {
        this.transactionId = transactionId;

    }

    public TransactionId() {
    }



    public void setTransactionId(String uniqueId) {
        this.transactionId = transactionId;

    }
    public String getTransactionId() {
        return transactionId;
    }

}
