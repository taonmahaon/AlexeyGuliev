package com.epam.tc.hw3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

    public static Properties getProperty() {
        Properties prop = new Properties();
        try (
            InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}


