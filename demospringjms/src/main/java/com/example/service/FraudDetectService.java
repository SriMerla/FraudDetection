package com.example.service;

import com.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectService {

    @Autowired
    JdbcFraudDetectRepo jdbcFraudDetectRepo;
    @Autowired
    User user;

    public void savetodb(User user){
        jdbcFraudDetectRepo.save(user);
    }

    public boolean isTransactionDuplicateIn10(int cardNo){



        if(jdbcFraudDetectRepo.findBycardNo(cardNo) <= 10){

            return true;

        }
        else{
            return false;
        }



    }



}
