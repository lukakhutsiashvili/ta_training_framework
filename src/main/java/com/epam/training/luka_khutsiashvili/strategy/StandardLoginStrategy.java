package com.epam.training.luka_khutsiashvili.strategy;

import com.epam.training.luka_khutsiashvili.pages.LoginPage;

public class StandardLoginStrategy implements LoginStrategy {

  private final LoginPage loginPage;

  public StandardLoginStrategy(LoginPage loginPage) {
    this.loginPage = loginPage;
  }

  @Override
  public void login(String username, String password) {
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();
  }
}
