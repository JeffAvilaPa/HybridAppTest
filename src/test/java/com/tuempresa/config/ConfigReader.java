package com.tuempresa.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader() {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo cargar el archivo de configuración", ex);
        }
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}
