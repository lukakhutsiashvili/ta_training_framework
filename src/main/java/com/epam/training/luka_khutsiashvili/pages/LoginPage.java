package com.epam.training.luka_khutsiashvili.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.training.luka_khutsiashvili.utils.ElementHighlighterUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

  private final SelenideElement usernameField = $("#user-name");
  private final SelenideElement passwordField = $("#password");
  private final SelenideElement loginButton = $("#login-button");

  public void enterUsername(String username) {
    usernameField.shouldBe(visible);
    ElementHighlighterUtils.highlightElement(usernameField);
    usernameField.setValue(username);
  }

  public void enterPassword(String password) {
    passwordField.shouldBe(visible);
    ElementHighlighterUtils.highlightElement(passwordField);
    passwordField.setValue(password);
  }

  public void clickLoginButton() {
    loginButton.shouldBe(visible);
    ElementHighlighterUtils.highlightElement(loginButton);
    loginButton.click();
  }

  public void login(String username, String password) {
    enterUsername(username);
    enterPassword(password);
    clickLoginButton();
  }
}
