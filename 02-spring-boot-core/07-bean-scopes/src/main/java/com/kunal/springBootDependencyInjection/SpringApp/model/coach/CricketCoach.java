package com.kunal.springBootDependencyInjection.SpringApp.model.coach;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

  CricketCoach() {
    System.out.println("Inside CricketCoach");
  }
  @Override
  public String getDailyWorkout() {
    return "Cricket:: Treadmill for 15 mins twice, weihted exercise for 30 mins twice";
  }
}
