package com.example.service;


import com.example.user.User;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Repository
public class JdbcFraudDetectRepo implements FraudDetectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   /* private static java.sql.Timestamp getCurrentTimeStamp() {

        java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());



    }*/


    @Override
    public void save(User user) {

       // final String ts = String.valueOf(getCurrentTimeStamp());
       Timestamp ts = Timestamp.valueOf(user.getTransactionTs());
        final String sql_insert = "insert into TRANSACTIONS(TRANSACTION_ID, CARD_NO, AMOUNT, TRANSACTION_TS ) values(?, ?, ?, ?)";
        Object[] userParam = new Object[]{user.getTransactionId(), user.getCardNo(), user.getAmount(), ts};
        jdbcTemplate.update(sql_insert, userParam);

    }

    @Override
    public void insert(User user) {
        jdbcTemplate.update("insert into TRANSACTIONS(TRANSACTION_ID, CARD_NO, AMOUNT, TRANSACTION_TS ) value(?, ?, ?, ?)");

    }

    @Override
    public void delete(String cardNo) {
        jdbcTemplate.update("delete TRANSACTIONS where cardNo = ?");
    }




    @Override
    public String findBycardNo(String cardNo) {
       return jdbcTemplate.queryForObject("select max (TRANSACTION_TS) from TRANSACTIONS where CARD_NO =  ? ",
               new Object[]{cardNo},
               String.class);

    }

    @Override
    public boolean findBycardNoInLasTenMinutes(String cardNo) {
        return jdbcTemplate.queryForObject("select COUNT(*) from TRANSACTIONS where CARD_NO = ? AND TRANSACTION_TS > SYSTIMESTAMP - INTERVAL '10' MINUTE",
                new Object[]{cardNo},
                Integer.class) > 0;

    }


    @Override
    public List<User> findAll() {
       return jdbcTemplate.query("select * from TRANSACTIONS",
                ((rs, rowNum) -> new User(rs.getString("TRANSACTION_ID"),
                                          rs.getString("CARD_NO"),
                                          rs.getString("AMOUNT"),
                                          rs.getString("TRANSACTION_TS")
                ))
       );
    }
}
