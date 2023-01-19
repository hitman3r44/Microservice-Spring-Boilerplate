package com.wolverine.solutions.accountservice;

import com.wolverine.solutions.accountservice.config.DevcontainerInitializer;

public class LocalDevcontainerApplication {

  public static void main(String[] args) {
    DevcontainerInitializer.getProperties()
        .forEach((k, v) -> System.setProperty(k, String.valueOf(v)));
    DevcontainerInitializer.getProperties()
        .forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
    AccountServiceApplication.main(args);
  }
}
