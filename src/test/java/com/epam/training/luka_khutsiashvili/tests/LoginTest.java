package com.epam.training.luka_khutsiashvili.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.training.luka_khutsiashvili.factory.DriverFactory;
import com.epam.training.luka_khutsiashvili.models.User;
import com.epam.training.luka_khutsiashvili.models.UserFactory;
import com.epam.training.luka_khutsiashvili.pages.LoginPage;
import com.epam.training.luka_khutsiashvili.pages.ProductsPage;
import com.epam.training.luka_khutsiashvili.utils.ConfigLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

@Listeners(com.epam.training.luka_khutsiashvili.listeners.TestListener.class)
public class LoginTest {

  private static final Logger logger = LogManager.getLogger(LoginTest.class);
  private LoginPage loginPage;
  private ProductsPage productsPage;

  @BeforeMethod
  @Parameters({"browser", "environment"})
  public void setUp(String browser, String environment) {
    logger.info("Setting up tests with browser: {} and environment: {}", browser, environment);
    ConfigLoader.loadProperties(environment);
    WebDriver webDriver = DriverFactory.initializeDriver(browser);
    WebDriverRunner.setWebDriver(webDriver);
    open(ConfigLoader.getProperty("base.url"));
    loginPage = new LoginPage();
    productsPage = new ProductsPage();
  }

  @Test(description = "Verify that a user can log in with valid credentials.")
  public void testValidLogin() {
    logger.info("Starting valid login test.");
    User standardUser = UserFactory.getStandardUser();
    loginPage.login(standardUser.getUsername(), standardUser.getPassword());
    productsPage.getProductsTitle().shouldBe(visible);
    logger.info("Valid login test passed.");
  }

  @Test(description = "Verify screenshot capture on test failure.")
  public void testScreenshotOnFailureScenario() {
    logger.info("Starting intentional failure test for screenshot validation.");
    User lockedOutUser = UserFactory.getInvalidUser();
    loginPage.login(lockedOutUser.getUsername(), lockedOutUser.getPassword());

    productsPage.getProductsTitle().shouldBe(visible);
    logger.warn("This test is expected to fail to verify screenshot capture.");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    logger.info("Closing browser after test.");
    WebDriverRunner.closeWebDriver();
    DriverFactory.quitDriver();
  }
}
