package com.example.customercontrols.service;

import com.example.customercontrols.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcCustomerControlsRepo implements CustomerControlsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findByCardNumber(String cardNo) {
        return jdbcTemplate.queryForObject("select cardEnable from TRANSACTION_CUSTOMERS where CARD_NO =  ? ",
                new Object[]{cardNo},
                String.class);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from TRANSACTION_CUSTOMERS",
                ((rs, rowNum) -> new User(rs.getString("USERNAME"),
                        rs.getString("PASSWORD"),
                        rs.getString("CARD_ENABLE")
                ))
        );
    }
}
