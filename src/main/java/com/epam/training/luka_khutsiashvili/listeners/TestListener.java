package com.epam.training.luka_khutsiashvili.listeners;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import com.epam.training.luka_khutsiashvili.factory.DriverFactory;
import com.epam.training.luka_khutsiashvili.utils.ScreenshotUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class TestListener extends ReportPortalTestNGListener {

  private static final Logger logger = LogManager.getLogger(TestListener.class);

  @Override
  public void onTestFailure(ITestResult result) {
    WebDriver driver = DriverFactory.getDriver();
    if (driver == null) {
      logger.error("Test '{}' failed, but WebDriver was null. Screenshot not taken.", result.getName());
      return;
    }

    String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
    if (screenshotPath == null) {
      logger.error("Screenshot capture failed for test '{}'", result.getName());
      return;
    }

    try {
      byte[] fileContent = Files.readAllBytes(Paths.get(screenshotPath));
      String base64Screenshot = Base64.getEncoder().encodeToString(fileContent);

      logger.info("RP_MESSAGE#BASE64#{}#{}", base64Screenshot, "Screenshot on Failure");
    } catch (IOException e) {
      logger.error("Failed to attach screenshot to ReportPortal: {}", e.getMessage());
    }

    super.onTestFailure(result);
  }
}
