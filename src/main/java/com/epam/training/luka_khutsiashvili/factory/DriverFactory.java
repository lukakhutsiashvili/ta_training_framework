package com.epam.training.luka_khutsiashvili.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static WebDriver initializeDriver(String browser) {
    if (browser == null) browser = "chrome";

    switch (browser.toLowerCase()) {
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver.set(new FirefoxDriver());
        break;
      case "chrome":
      default:
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        break;
    }

    getDriver().manage().window().maximize();
    return getDriver();
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
