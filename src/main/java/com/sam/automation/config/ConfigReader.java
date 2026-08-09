package com.sam.automation.config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try{
            loadProperties();
        } catch (IOException e){
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private static void loadProperties() throws IOException {

        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties file not found."
                );
            }
            properties.load(input);
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}
