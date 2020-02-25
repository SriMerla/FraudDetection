package com.example.customercontrols.User;

import org.springframework.stereotype.Component;

@Component
public class UserTransactions {

    private String transactionId;
    private String cardNo;
    private String amount;
    private String transactionTS;

    public UserTransactions(String transactionId, String cardNo, String amount, String transactionTS) {
        this.transactionId = transactionId;
        this.cardNo = cardNo;
        this.amount = amount;
        this.transactionTS = transactionTS;
    }

    public UserTransactions() {

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

    public String getTransactionTS() {
        return transactionTS;
    }

    public void setTransactionTS() {
        this.transactionTS = transactionTS;
    }
}
