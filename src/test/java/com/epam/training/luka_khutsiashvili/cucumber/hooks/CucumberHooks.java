package com.epam.training.luka_khutsiashvili.cucumber.hooks;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.training.luka_khutsiashvili.config.ConfigLoader;
import com.epam.training.luka_khutsiashvili.config.SelenideConfig;
import com.epam.training.luka_khutsiashvili.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

  @Before
  public void setUp() {
    SelenideConfig.configure();
    ConfigLoader.loadProperties("dev");
    WebDriver webDriver = DriverFactory.initializeDriver("chrome");
    WebDriverRunner.setWebDriver(webDriver);
  }

  @After
  public void tearDown() {
    WebDriverRunner.closeWebDriver();
    DriverFactory.quitDriver();
  }
}
