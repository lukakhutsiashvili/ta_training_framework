package com.epam.training.luka_khutsiashvili.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
  private static final Logger logger = LogManager.getLogger(PropertyReader.class);
  private final Properties properties = new Properties();

  public PropertyReader(String filePath) {
    try (InputStream input = getClass().getClassLoader().getResourceAsStream(filePath)) {
      if (input == null) {
        throw new RuntimeException("Properties file not found: " + filePath);
      }
      properties.load(input);
      logger.info("Loaded properties from '{}'", filePath);
    } catch (IOException e) {
      logger.error("Failed to load properties file: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
