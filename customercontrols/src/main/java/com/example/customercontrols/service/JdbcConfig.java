package com.example.customercontrols.service;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
public class JdbcConfig {

    @Bean
    public DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL("jdbc:oracle:thin:@192.168.1.227:1521/orcl");
        dataSource.setUser("system");
        dataSource.setPassword("oracle");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }


    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}


