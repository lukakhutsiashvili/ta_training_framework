package com.epam.training.luka_khutsiashvili.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements BrowserFactory {

  @Override
  public WebDriver createDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();
  }
}
