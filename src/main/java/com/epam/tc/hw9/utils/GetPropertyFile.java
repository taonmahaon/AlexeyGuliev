package com.epam.tc.hw9.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyFile {

    public static Properties getProperty() {
        Properties prop = new Properties();
        try (
            InputStream input = new FileInputStream("src/test/resources/testHw10.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}


