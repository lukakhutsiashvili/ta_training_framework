package com.epam.training.luka_khutsiashvili.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.epam.training.luka_khutsiashvili.factory.DriverFactory;
import com.epam.training.luka_khutsiashvili.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

  private static final Logger logger = LogManager.getLogger(TestListener.class);

  @Override
  public void onTestFailure(ITestResult result) {
    WebDriver driver = DriverFactory.getDriver();
    if (driver != null) {
      String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
      logger.error("Test '{}' failed. Screenshot saved at: {}", result.getName(), screenshotPath);
    } else {
      logger.error("Test '{}' failed, but WebDriver was null. Screenshot not taken.", result.getName());
    }
  }

  @Override
  public void onTestStart(ITestResult result) {
    logger.info("Test '{}' started.", result.getName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    logger.info("Test '{}' passed.", result.getName());
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    logger.warn("Test '{}' skipped.", result.getName());
  }

  @Override
  public void onStart(ITestContext context) {
    logger.info("Test suite '{}' started.", context.getName());
  }

  @Override
  public void onFinish(ITestContext context) {
    logger.info("Test suite '{}' finished.", context.getName());
  }
}
