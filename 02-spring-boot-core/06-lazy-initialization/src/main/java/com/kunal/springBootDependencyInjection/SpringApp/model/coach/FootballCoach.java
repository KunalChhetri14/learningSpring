package com.kunal.springBootDependencyInjection.SpringApp.model.coach;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

  FootballCoach() {
    System.out.println("Inside FootballCoach");
  }

  @Override
  public String getDailyWorkout() {
    return "Football: Cardio, stretching and skills traning";
  }
}
