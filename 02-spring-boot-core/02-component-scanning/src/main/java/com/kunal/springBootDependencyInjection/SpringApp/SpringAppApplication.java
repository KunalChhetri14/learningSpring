package com.kunal.springBootDependencyInjection.SpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (
  scanBasePackages = {
    "com.kunal.springBootDependencyInjection.SpringApp",
    "com.kunal.springBootDependencyInjection.util"
  }
)
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}
}
