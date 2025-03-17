package com.petstore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {

    private static final String CONFIGURATION_FILE = "configuration.properties";
    private final Properties properties;

    public ConfigurationLoader() {
        this.properties = new Properties();
        loadConfiguration();
    }

    private void loadConfiguration() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIGURATION_FILE)) {
            if (inputStream == null) {
                throw new RuntimeException(CONFIGURATION_FILE + " not found");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error loading " + CONFIGURATION_FILE, e);
        }
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property " + key + " is missing in " + CONFIGURATION_FILE);
        }
        return value;
    }

}
