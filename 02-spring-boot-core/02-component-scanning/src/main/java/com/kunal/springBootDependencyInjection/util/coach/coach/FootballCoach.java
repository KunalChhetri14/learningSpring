package com.kunal.springBootDependencyInjection.util.coach.coach;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
  @Override
  public String getDailyWorkout() {
    return "Cardio, stretching and skills traning";
  }
}
