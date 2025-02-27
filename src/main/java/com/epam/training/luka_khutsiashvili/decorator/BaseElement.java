package com.epam.training.luka_khutsiashvili.decorator;

import com.codeborne.selenide.SelenideElement;

public class BaseElement implements Element {
  protected final SelenideElement element;

  public BaseElement(SelenideElement element) {
    this.element = element;
  }

  @Override
  public void click() {
    element.click();
  }

  @Override
  public void setValue(String value) {
    element.setValue(value);
  }

  @Override
  public String getText() {
    return element.getText();
  }
}
