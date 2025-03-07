package com.epam.training.luka_khutsiashvili.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
        "com.epam.training.luka_khutsiashvili.cucumber.steps",
        "com.epam.training.luka_khutsiashvili.cucumber.hooks"
    },
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
