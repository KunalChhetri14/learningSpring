package com.kunal.springBootDependencyInjection.SpringApp.controller;

import com.kunal.springBootDependencyInjection.SpringApp.model.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  //define a private field for the dependency
  private Coach coach;

  //define a constructor for dependency injection
  @Autowired
  DemoController(Coach coach) {
    this.coach = coach;
  }

  @GetMapping("/dailyWorkout")
  public String getWorkout() {
    return this.coach.getDailyWorkout();
  }

}
