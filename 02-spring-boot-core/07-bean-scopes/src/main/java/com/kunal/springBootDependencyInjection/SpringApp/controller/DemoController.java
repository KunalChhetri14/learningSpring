package com.kunal.springBootDependencyInjection.SpringApp.controller;

import com.kunal.springBootDependencyInjection.SpringApp.model.coach.Coach;
import com.kunal.springBootDependencyInjection.SpringApp.model.coach.CricketCoach;
import com.kunal.springBootDependencyInjection.SpringApp.model.coach.FootballCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  //define a private field for the dependency
  private Coach cricketCoachObj;
  private Coach footballCoach;
  private Coach baseballCoach;

  private Coach anotherCricketCoachObj;

  //define a constructor for dependency injection
  @Autowired
  DemoController(@Qualifier("cricketCoach") Coach cricketCoachObj,@Qualifier("cricketCoach") Coach anotherCricketCoach, @Qualifier("footballCoach") Coach footballCoachObj,
                 @Qualifier("baseballCoach") Coach baseballCoachObj) {
    this.cricketCoachObj = cricketCoachObj;
    this.footballCoach = footballCoachObj;
    this.baseballCoach = baseballCoachObj;
    this.anotherCricketCoachObj = anotherCricketCoach;
    System.out.println("Both cricket obj are same: "+ (this.cricketCoachObj == this.anotherCricketCoachObj));
  }

  @GetMapping("/dailyWorkoutCricket")
  public String getCricketWorkout() {
    return this.cricketCoachObj.getDailyWorkout();
  }

  @GetMapping("/dailyWorkoutFootball")
  public String getFootballWorkout() {
    return this.footballCoach.getDailyWorkout();
  }

  @GetMapping("/dailyWorkoutBaseball")
  public String getBaseballWorkout() { return this.baseballCoach.getDailyWorkout(); }

}
