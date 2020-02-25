package com.example.customercontrols.User;


import org.springframework.stereotype.Component;

@Component
public class User {

    private String userName;
    private String password;
    private String cardEnable;

    public User(){

    }

    public User(String userName, String password, String cardEnable) {
        this.userName = userName;
        this.password = password;
        this.cardEnable = cardEnable;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getpassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getCardEnable() {
        return cardEnable;
    }

    public void setCardEnable(String cardEnable) {
        this.cardEnable = cardEnable;
    }
}
