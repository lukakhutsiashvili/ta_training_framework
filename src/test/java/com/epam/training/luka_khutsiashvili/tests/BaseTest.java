package com.epam.training.luka_khutsiashvili.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.training.luka_khutsiashvili.factory.DriverFactory;
import com.epam.training.luka_khutsiashvili.config.ConfigLoader;
import com.epam.training.luka_khutsiashvili.config.SelenideConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;

@Listeners(com.epam.training.luka_khutsiashvili.listeners.TestListener.class)
public abstract class BaseTest {

  @BeforeMethod
  @Parameters({"browser", "environment"})
  public void setUp(@Optional("chrome") String browser, @Optional("dev") String environment) {
    SelenideConfig.configure();
    ConfigLoader.loadProperties(environment);
    WebDriver webDriver = DriverFactory.initializeDriver(browser);
    WebDriverRunner.setWebDriver(webDriver);
    open(ConfigLoader.getProperty("base.url"));
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    WebDriverRunner.closeWebDriver();
    DriverFactory.quitDriver();
  }
}
