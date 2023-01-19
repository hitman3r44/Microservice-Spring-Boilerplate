package com.wolverine.solutions.accountservice.config;

import java.util.Map;
import java.util.stream.Stream;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;

public abstract class DevcontainerInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {
  private static final MySQLContainer<?> MYSQL_CONTAINER =
      new MySQLContainer<>("mysql:5.7.37-oracle");

  public static Map<String, Object> getProperties() {
    Startables.deepStart(Stream.of(MYSQL_CONTAINER)).join();

    return Map.of(
        "spring.datasource.url", MYSQL_CONTAINER.getJdbcUrl(),
        "spring.datasource.username", MYSQL_CONTAINER.getUsername(),
        "spring.datasource.password", MYSQL_CONTAINER.getPassword());
  }

  @Override
  public void initialize(ConfigurableApplicationContext context) {
    var env = context.getEnvironment();
    env.getPropertySources().addFirst(new MapPropertySource("devcontainers", getProperties()));
  }
}
