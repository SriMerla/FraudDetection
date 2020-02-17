package com.example.service;


import com.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcFraudDetectRepo implements FraudDetectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        final String sql_insert = "insert into TRANSACTIONS(TRANSACTION_ID, CARD_NO, AMOUNT, TRANSACTION_TS ) values(?, ?, ?, ?)";
        Object[] userParam = new Object[]{user.getTransactionId(), user.getCardNo(), user.getAmount(), user.getTransactionTs()};
        jdbcTemplate.update(sql_insert, userParam);

    }

    @Override
    public void insert(User user) {
        jdbcTemplate.update("insert into TRANSACTIONS(TRANSACTION_ID, CARD_NO, AMOUNT, TRANSACTION_TS ) value(?, ?, ?, ?)");

    }

    @Override
    public void delete(int cardNo) {
        jdbcTemplate.update("delete TRANSACTIONS where cardNo = ?");
    }




    @Override
    public int findBycardNo(int cardNo) {
       return jdbcTemplate.queryForObject("select (TRANSACTION_TS) from TRANSACTIONS where CARD_NO =  ? ",
               new Object[]{cardNo},
               Integer.class);

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
