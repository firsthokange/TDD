/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.fc.data.access.generator;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class DataAccessGeneratorTest {
    
    public DataAccessGeneratorTest() {
    }
    
    DataAccessGenerator dataAccessGenerator = new DataAccessGenerator();
    
    @Test
    public void xml_file_contain_dataset_tag(){
        File fXmlFile = new File("src/main/java/data_repository.xml");
        dataAccessGenerator.setfXmlFile(fXmlFile);
        assertTrue(dataAccessGenerator.isValidFormat());
    }
    
    @Test
    public void xml_file_not_valid(){
        File fXmlFile = new File("src/main/java/data_repository_invalid_format.xml");
        dataAccessGenerator.setfXmlFile(fXmlFile);
        assertFalse(dataAccessGenerator.isValidFormat());
    }
    
    @Test
    public void xml_valid_read1_should_returnCON_REPO(){
        File fXmlFile = new File("src/main/java/data_repository.xml");
        dataAccessGenerator.setfXmlFile(fXmlFile);
        dataAccessGenerator.read();
    }
}
