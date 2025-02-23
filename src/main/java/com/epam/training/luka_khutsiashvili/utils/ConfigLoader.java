package com.epam.training.luka_khutsiashvili.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

  private static final Logger logger = LogManager.getLogger(ConfigLoader.class);
  private static final Properties properties = new Properties();

  public static void loadProperties(String env) {
    String filePath = String.format("config/%s.properties", env.toLowerCase());
    try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(filePath)) {
      if (input == null) {
        throw new RuntimeException("Properties file not found: " + filePath);
      }
      properties.load(input);
      logger.info("Loaded environment properties from '{}'", filePath);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load properties file: " + filePath, e);
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}
