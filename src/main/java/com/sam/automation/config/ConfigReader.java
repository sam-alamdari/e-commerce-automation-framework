package com.sam.automation.config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {

        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            System.out.println("InputStream = " + input);

            if (input == null) {
                throw new RuntimeException(
                        "config.properties file not found in resources."
                );
            }

            properties.load(input);

            System.out.println("Config file loaded successfully");

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to load config.properties.",
                    e
            );
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }

}
