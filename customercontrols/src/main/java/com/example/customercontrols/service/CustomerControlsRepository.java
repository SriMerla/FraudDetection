package com.example.customercontrols.service;

import com.example.customercontrols.User.User;

import java.util.List;

public interface CustomerControlsRepository {

   // public void save(User user);

  //  public void insert(User user);

    //public void delete(String cardNo);

    public String findByCardNumber(String userName);

    public List<User> findAll();

}
