/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.fc.str2017.config;

import com.tech.fc.str2017.service.BaseTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author admin
 */
@Configuration
//@ComponentScan("com.tech.custodian.dao,"
//        + "com.tech.custodian.service")
@ComponentScan("com.tech.fc.str2017.service")
public class TestConfig {
    
    @Bean
    public org.apache.commons.dbcp.BasicDataSource dataSourceOracle() {
        org.apache.commons.dbcp.BasicDataSource ret
                = new org.apache.commons.dbcp.BasicDataSource();
        ret.setDriverClassName(BaseTest.JDBC_DRIVER);
        ret.setUrl(BaseTest.JDBC_URL);
        ret.setUsername(BaseTest.USER);
        ret.setPassword(BaseTest.PASSWORD);
        ret.setInitialSize(5);
        ret.setMaxActive(10);
        ret.setDefaultAutoCommit(false);
        return ret;
    }

    @Bean
    public org.springframework.jdbc.core.JdbcTemplate jdbcTemplate() {
        org.springframework.jdbc.core.JdbcTemplate ret
                = new org.springframework.jdbc.core.JdbcTemplate();
        ret.setDataSource(dataSourceOracle());
        return ret;
    }

    @Bean
    public org.springframework.jdbc.datasource.DataSourceTransactionManager txManager() {
        org.springframework.jdbc.datasource.DataSourceTransactionManager ret
                = new org.springframework.jdbc.datasource.DataSourceTransactionManager();
        ret.setDataSource(dataSourceOracle());
        return ret;
    }
}
