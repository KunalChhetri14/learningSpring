package com.kunal.springBootDependencyInjection.SpringApp.model.coach;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
  @Override
  public String getDailyWorkout() {
    return "Treadmill for 15 mins twice, weihted exercise for 30 mins twice";
  }
}
