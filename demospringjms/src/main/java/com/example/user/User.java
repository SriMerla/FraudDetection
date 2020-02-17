package com.example.user;

import org.springframework.stereotype.Component;



@Component
public class User {

    private String transactionId;
    private String cardNo;
    private String amount;
    private String transactionTs;


    public User(){

    }

    public User(String transactionId, String cardNo, String amount, String transactionTs) {
        this.transactionId = transactionId;
        this.cardNo = cardNo;
        this.amount = amount;
        this.transactionTs = transactionTs;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionTs() {
        return transactionTs;
    }

    public void setTransactionTs(String transactionTs) {
        this.transactionTs = transactionTs;
    }
}
