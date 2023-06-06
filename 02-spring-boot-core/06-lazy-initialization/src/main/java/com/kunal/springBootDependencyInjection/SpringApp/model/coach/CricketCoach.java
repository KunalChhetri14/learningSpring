package com.kunal.springBootDependencyInjection.SpringApp.model.coach;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

  CricketCoach() {
    System.out.println("Inside CricketCoach");
  }
  @Override
  public String getDailyWorkout() {
    return "Cricket:: Treadmill for 15 mins twice, weihted exercise for 30 mins twice";
  }
}
