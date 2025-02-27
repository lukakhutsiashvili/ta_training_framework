package com.epam.training.luka_khutsiashvili.decorator;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class HighlightingDecorator extends ElementDecorator {

  public HighlightingDecorator(Element decoratedElement) {
    super(decoratedElement);
  }

  private void highlight(SelenideElement element) {
    executeJavaScript("arguments[0].style.border='3px solid red';", element);
  }

  @Override
  public void click() {
    highlight(((BaseElement) decoratedElement).element);
    super.click();
  }

  @Override
  public void setValue(String value) {
    highlight(((BaseElement) decoratedElement).element);
    super.setValue(value);
  }
}
