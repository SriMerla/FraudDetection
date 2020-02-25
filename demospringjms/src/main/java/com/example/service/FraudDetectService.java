package com.example.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.user.User;
import com.sun.jmx.snmp.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import oracle.sql.DATE;
import org.apache.activemq.broker.util.TimeStampingBrokerPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Service
public class FraudDetectService {

    @Autowired
    JdbcFraudDetectRepo jdbcFraudDetectRepo;
    @Autowired
    User user;

    public void savetodb(User user){
        jdbcFraudDetectRepo.save(user);
    }

    public boolean isTransactionDuplicateIn10(String cardNo) throws ParseException {
        boolean isTransactionDuplicateIn10 = jdbcFraudDetectRepo.findBycardNoInLasTenMinutes(cardNo);

        return isTransactionDuplicateIn10;

    }



}
