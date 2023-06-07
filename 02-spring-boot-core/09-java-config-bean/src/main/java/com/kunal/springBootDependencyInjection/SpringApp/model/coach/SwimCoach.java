package com.kunal.springBootDependencyInjection.SpringApp.model.coach;

public class SwimCoach implements Coach{

  public SwimCoach() {
    System.out.println("In constructor:: "+ getClass().getSimpleName());
  }
  @Override
  public String getDailyWorkout() {
    return "Swim workout:: 1000m as warmup";
  }

}
