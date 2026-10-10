package com.gdb.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AccountRulesPropertiesLoader {
  private Properties properties;

  public AccountRulesPropertiesLoader(String filePath) {
    properties = new Properties();
    try (FileInputStream fis = new FileInputStream(filePath)) {
      properties.load(fis);
    } catch (IOException e) {
      System.out.println("Error loading properties: " + e.getMessage());
    }
  }

  public String getProperty(String key, String defaultValue) {
    return properties.getProperty(key, defaultValue);
  }

  public double getDouble(String key, double defaultValue) {
    String value = properties.getProperty(key);
    if (value != null) {
      try {
        return Double.parseDouble(value);
      } catch (NumberFormatException e) {
        return defaultValue;
      }
    }
    return defaultValue;
  }
}
