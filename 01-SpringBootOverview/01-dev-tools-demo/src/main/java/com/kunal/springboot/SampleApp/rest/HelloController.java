package com.kunal.springboot.SampleApp.rest;

import com.kunal.springboot.SampleApp.SampleAppApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Value("owner.name")
  private String name;

  @GetMapping("/")
  public String sayHello() {
    System.out.println("THe name is : "+ name);
    return "Hellow World";
  }

  @GetMapping("/workout")
  public String workout() {
    return "Workout";
  }
}
