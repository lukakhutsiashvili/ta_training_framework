package com.epam.training.luka_khutsiashvili.config;

import com.codeborne.selenide.Configuration;

public class SelenideConfig {
  public static void configure() {
    Configuration.reportsFolder = "target/selenide-reports";
  }
}
