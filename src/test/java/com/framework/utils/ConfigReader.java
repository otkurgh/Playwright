
package com.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Configuration property not found: " + key);
        }

        // Resolve environment variable placeholders: ${VARIABLE_NAME}
        if (value.startsWith("${") && value.endsWith("}")) {

            String envVariable = value.substring(2, value.length() - 1);
            value = System.getenv(envVariable);

            if (value == null || value.isBlank()) {
                throw new RuntimeException(
                        "Environment variable not configured: " + envVariable);
            }
        }

        return value;
    }
}
