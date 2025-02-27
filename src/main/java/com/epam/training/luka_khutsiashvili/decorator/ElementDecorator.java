package com.epam.training.luka_khutsiashvili.decorator;

public abstract class ElementDecorator implements Element {
  protected final Element decoratedElement;

  public ElementDecorator(Element decoratedElement) {
    this.decoratedElement = decoratedElement;
  }

  @Override
  public void click() {
    decoratedElement.click();
  }

  @Override
  public void setValue(String value) {
    decoratedElement.setValue(value);
  }

  @Override
  public String getText() {
    return decoratedElement.getText();
  }
}
