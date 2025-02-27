package com.epam.training.luka_khutsiashvili.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class ProductsPage implements Page {

  private final SelenideElement productsTitle = $(".title");

  @Override
  public boolean isLoaded() {
    return productsTitle.shouldBe(visible).exists();
  }
}
