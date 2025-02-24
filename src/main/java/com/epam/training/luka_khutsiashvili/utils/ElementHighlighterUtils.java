package com.epam.training.luka_khutsiashvili.utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ElementHighlighterUtils {

  public static void highlightElement(SelenideElement element) {
    String highlightScript = "arguments[0].style.border='3px solid red'; "
        + "arguments[0].style.transition='border 0.5s ease-in-out';";
    executeJavaScript(highlightScript, element);
  }
}
