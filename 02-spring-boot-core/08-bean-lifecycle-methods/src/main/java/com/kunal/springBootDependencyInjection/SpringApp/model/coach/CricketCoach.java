package com.kunal.springBootDependencyInjection.SpringApp.model.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
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

  @PreDestroy
  public void preBeanDestroy() {
    System.out.println("After component  :: "+getClass().getSimpleName()+ "  destroyed.");
  }

  @PostConstruct
  public void postBeanInit() {
    System.out.println("After component:: " + getClass().getSimpleName() + " init");
  }
}
