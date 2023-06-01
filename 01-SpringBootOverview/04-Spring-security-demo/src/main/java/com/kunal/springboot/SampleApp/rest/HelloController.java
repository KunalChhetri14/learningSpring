package com.kunal.springboot.SampleApp.rest;

import com.kunal.springboot.SampleApp.SampleAppApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Value("${owner.name}")
  private String name;

  @Value("${owner.age}")
  private String age;

  @Value("${database.name}")
  private String databaseName;


  @GetMapping("/")
  public String sayHello() {
    System.out.println("THe name is :   "+ name + " , age:: "+ age + "  database name:: "+ databaseName);
    return "Hellow World ddd";
  }

  @GetMapping("/workout")
  public String workout() {
    return "Workout";
  }
}
