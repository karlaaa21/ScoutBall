package com.duoc.Scoutball;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
  info = @Info(
    title = "Scoutball API",
    version = "1.0"
  ),
  security = @SecurityRequirement(name = "Bearer Authentication")
)
@SecurityScheme(
  name = "Bearer Authentication",
  type = SecuritySchemeType.HTTP,
  scheme = "bearer",
  bearerFormat = "JWT"
)
public class ScoutballApplication {
  public static void main(String[] args) {
    SpringApplication.run(ScoutballApplication.class, args);
  }

}