package com.epam.training.luka_khutsiashvili.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  private DriverFactory() {}

  public static WebDriver initializeDriver(String browser) {
    if (driver.get() == null) {
      BrowserFactory browserFactory = getBrowserFactory(browser);
      driver.set(browserFactory.createDriver());
      driver.get().manage().window().maximize();
    }
    return driver.get();
  }

  private static BrowserFactory getBrowserFactory(String browser) {
    if (browser == null) browser = "chrome";
    switch (browser.toLowerCase()) {
      case "firefox":
        return new FirefoxDriverFactory();
      case "chrome":
      default:
        return new ChromeDriverFactory();
    }
  }

  public static WebDriver getDriver() {
    return driver.get();
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
