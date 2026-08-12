package com.sam.automation.config;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            loadProperties();
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load config.properties",
                    e
            );
        }
    }

    private static void loadProperties() throws IOException {

        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "config.properties file not found."
                );
            }

            properties.load(input);
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Configuration property not found or empty: " + key
            );
        }

        return value.trim();
    }

    public static long getLongProperty(String key) {

        String value = getProperty(key);

        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Configuration property must be a valid number: "
                            + key + "=" + value,
                    e
            );
        }
    }
    public static boolean getBooleanProperty(String key) {

        String value = getProperty(key);

        if (!value.equalsIgnoreCase("true")
                && !value.equalsIgnoreCase("false")) {

            throw new IllegalArgumentException(
                    "Configuration property must be true or false: "
                            + key + "=" + value
            );
        }

        return Boolean.parseBoolean(value);
    }
}
