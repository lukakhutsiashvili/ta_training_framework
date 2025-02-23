package com.epam.training.luka_khutsiashvili.models;

import com.epam.training.luka_khutsiashvili.utils.ConfigLoader;

public class UserFactory {

  public static User getStandardUser() {
    return new User(ConfigLoader.getProperty("username"), ConfigLoader.getProperty("password"));
  }

  public static User getInvalidUser() {
    return new User("invalid_user", "wrong_password");
  }
}
