  package com.epam.training.luka_khutsiashvili.utils;

  import org.apache.logging.log4j.LogManager;
  import org.apache.logging.log4j.Logger;
  import org.openqa.selenium.OutputType;
  import org.openqa.selenium.TakesScreenshot;
  import org.openqa.selenium.WebDriver;

  import java.io.File;
  import java.io.IOException;
  import java.nio.file.Files;
  import java.nio.file.Paths;
  import java.text.SimpleDateFormat;
  import java.util.Date;

  public class ScreenshotUtils {

    private static final Logger logger = LogManager.getLogger(ScreenshotUtils.class);
    private static final String SCREENSHOT_DIR = "target/screenshots/";

    public static String takeScreenshot(WebDriver driver, String testName) {
      if (driver == null) {
        logger.error("Cannot take screenshot. WebDriver instance is null.");
        return null;
      }

      String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
      String screenshotPath = SCREENSHOT_DIR + testName + "_" + timestamp + ".png";

      try {
        Files.createDirectories(Paths.get(SCREENSHOT_DIR));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
        logger.info("Screenshot saved at: {}", screenshotPath);
        return screenshotPath;
      } catch (IOException e) {
        logger.error("Failed to save screenshot: {}", e.getMessage());
        return null;
      }
    }
  }
