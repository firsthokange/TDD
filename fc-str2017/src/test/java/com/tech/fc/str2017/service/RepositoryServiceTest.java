/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.fc.str2017.service;

import com.tech.fc.str2017.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class RepositoryServiceTest extends BaseTest {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RepositoryService reposirotyService;

    public RepositoryServiceTest() {

    }

    @Test
    public void count_repository_should_return2() {
        assertEquals(2, reposirotyService.getAll().size());
    }
}
