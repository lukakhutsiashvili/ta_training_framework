package com.epam.training.luka_khutsiashvili.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDecorator extends ElementDecorator {

  private static final Logger logger = LogManager.getLogger(LoggingDecorator.class);

  public LoggingDecorator(Element decoratedElement) {
    super(decoratedElement);
  }

  @Override
  public void click() {
    logger.info("Clicking on element.");
    super.click();
  }

  @Override
  public void setValue(String value) {
    logger.info("Setting value: '{}'", value);
    super.setValue(value);
  }

  @Override
  public String getText() {
    String text = super.getText();
    logger.info("Retrieved text: '{}'", text);
    return text;
  }
}
