package com.kunal.springBootDependencyInjection.SpringApp.model.coach;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

  BaseballCoach() {
    System.out.println("Inside BaseballCoach");
  }

  @Override
  public String getDailyWorkout() {
    return "Baseball workout";
  }
}
