package com.epam.training.luka_khutsiashvili.config;

public class ConfigLoader {
  private static PropertyReader propertyReader;

  private ConfigLoader() {}

  public static void loadProperties(String env) {
    String filePath = String.format("config/%s.properties", env.toLowerCase());
    propertyReader = new PropertyReader(filePath);
  }

  public static String getProperty(String key) {
    return propertyReader.getProperty(key);
  }
}
