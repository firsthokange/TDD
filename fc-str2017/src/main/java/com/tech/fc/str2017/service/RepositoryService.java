/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.fc.str2017.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class RepositoryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Map<String,Object>> getAll() {
        return jdbcTemplate.queryForList("SELECT * FROM CON_REPO");
    }

}
