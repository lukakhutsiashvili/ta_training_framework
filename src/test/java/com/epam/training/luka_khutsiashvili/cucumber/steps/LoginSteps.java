package com.epam.training.luka_khutsiashvili.cucumber.steps;

import static com.codeborne.selenide.Selenide.open;

import com.epam.training.luka_khutsiashvili.config.ConfigLoader;
import com.epam.training.luka_khutsiashvili.pages.LoginPage;
import com.epam.training.luka_khutsiashvili.pages.ProductsPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {
  private final LoginPage loginPage = new LoginPage();
  private final ProductsPage productsPage = new ProductsPage();

  @Given("I open the SauceDemo login page")
  public void iOpenTheSauceDemoLoginPage() {
    open(ConfigLoader.getProperty("base.url"));
  }

  @When("I enter username {string} and password {string}")
  public void iEnterUsernameAndPassword(String username, String password) {
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
  }

  @And("I click the login button")
  public void iClickTheLoginButton() {
    loginPage.clickLoginButton();
  }

  @Then("I should see the products page")
  public void iShouldSeeTheProductsPage() {
    Assert.assertTrue(productsPage.isLoaded(), "Products page should be visible after login.");
  }
}
