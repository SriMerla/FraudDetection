package com.example.generatetransactionid.User;

public class User {

    private String cardNo;
    private String amount;
    private String transactionTs;

    public User(){

    }

    public User(String cardNo, String amount, String transactionTs) {
        this.cardNo = cardNo;
        this.amount = amount;
        this.transactionTs = transactionTs;
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
