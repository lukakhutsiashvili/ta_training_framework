package com.epam.training.luka_khutsiashvili.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class ProductsPage {

  private final SelenideElement productsTitle = $(".title");

  public SelenideElement getProductsTitle() {
    return productsTitle.shouldBe(visible);
  }
}
