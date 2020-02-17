package com.example.service;

import com.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public interface FraudDetectRepository  {

     public void save(User user);

     public void insert(User user);

     public void delete(int cardNo);

     public int findBycardNo(int cardNo);

     public List<User> findAll();

}
