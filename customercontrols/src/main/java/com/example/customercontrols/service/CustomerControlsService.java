package com.example.customercontrols.service;


import com.example.customercontrols.User.User;
import com.example.customercontrols.User.UserTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerControlsService {

    @Autowired
    JdbcCustomerControlsRepo jdbcCustomerControlsRepo;

    @Autowired
    UserTransactions userTransactions;

    public String isCardEnabled(String cardNo){
     boolean cardEnable = Boolean.parseBoolean(jdbcCustomerControlsRepo.findByCardNumber(cardNo));

        if(cardEnable ==  true){
            return "user card is enabled, Transaction Processing";
           // return true;
        }else{
            return "user card is disabled , Transaction denied";
           // return false;
        }

    }

}
