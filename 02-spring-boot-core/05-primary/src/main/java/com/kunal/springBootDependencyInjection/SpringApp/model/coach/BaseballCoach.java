package com.kunal.springBootDependencyInjection.SpringApp.model.coach;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
  @Override
  public String getDailyWorkout() {
    return "Baseball workout";
  }
}
