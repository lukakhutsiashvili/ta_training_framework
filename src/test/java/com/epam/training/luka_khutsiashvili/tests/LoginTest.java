package com.epam.training.luka_khutsiashvili.tests;

import com.epam.training.luka_khutsiashvili.models.User;
import com.epam.training.luka_khutsiashvili.models.UserFactory;
import com.epam.training.luka_khutsiashvili.pages.LoginPage;
import com.epam.training.luka_khutsiashvili.pages.ProductsPage;
import com.epam.training.luka_khutsiashvili.strategy.LoginStrategy;
import com.epam.training.luka_khutsiashvili.strategy.StandardLoginStrategy;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

  private LoginPage loginPage;
  private ProductsPage productsPage;
  private LoginStrategy loginStrategy;

  @BeforeMethod
  public void pageSetUp() {
    loginPage = new LoginPage();
    productsPage = new ProductsPage();
    loginStrategy = new StandardLoginStrategy(loginPage);
  }

  @Test
  public void testValidLogin() {
    User standardUser = UserFactory.getStandardUser();
    loginStrategy.login(standardUser.getUsername(), standardUser.getPassword());
    assertTrue(productsPage.isLoaded(), "Products page should load after valid login.");
  }

  @Test
  @Parameters({"browser"})
  public void testScreenshotOnFailureScenario(@Optional("chrome") String browser) {
    User lockedOutUser = UserFactory.getInvalidUser();
    loginStrategy.login(lockedOutUser.getUsername(), lockedOutUser.getPassword());
    assertTrue(productsPage.isLoaded(), "Products page should not load with invalid credentials.");
  }
}
