package com.epam.training.luka_khutsiashvili.pages;

import com.epam.training.luka_khutsiashvili.decorator.BaseElement;
import com.epam.training.luka_khutsiashvili.decorator.Element;
import com.epam.training.luka_khutsiashvili.decorator.HighlightingDecorator;
import com.epam.training.luka_khutsiashvili.decorator.LoggingDecorator;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

  private final Element usernameField = new LoggingDecorator(new HighlightingDecorator(new BaseElement($("#user-name"))));
  private final Element passwordField = new LoggingDecorator(new HighlightingDecorator(new BaseElement($("#password"))));
  private final Element loginButton = new LoggingDecorator(new HighlightingDecorator(new BaseElement($("#login-button"))));

  public void enterUsername(String username) {
    usernameField.setValue(username);
  }

  public void enterPassword(String password) {
    passwordField.setValue(password);
  }

  public void clickLoginButton() {
    loginButton.click();
  }
}
