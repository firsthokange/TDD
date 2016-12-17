/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.fc.str2017.service;

import java.io.File;
import java.nio.charset.Charset;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author admin
 */
public class BaseTest {
    public static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    public static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    public static final String USER = "sa";
    public static final String PASSWORD = "";
    public static final String UTF8 = "UTF8";
    
    @BeforeClass
    public static void createSchema() throws Exception {
        RunScript.execute(JDBC_URL, USER, PASSWORD, 
                          "src/main/java/schema_log.sql", 
                          Charset.forName(UTF8), false);
    }
    
    @Before
    public void importDataSet() throws Exception {
        IDataSet dataSet = readDataSet();
        cleanlyInsert(dataSet);
    }

    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder()
        .build(new File("src/main/java/data_repository.xml"));
    }
    
    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER,
                JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }
}
