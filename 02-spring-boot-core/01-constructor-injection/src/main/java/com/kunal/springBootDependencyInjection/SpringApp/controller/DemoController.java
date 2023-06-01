package com.kunal.springBootDependencyInjection.SpringApp.controller;

import com.kunal.springBootDependencyInjection.SpringApp.model.coach.Coach;
import com.kunal.springBootDependencyInjection.SpringApp.model.coach.CricketCoach;
import com.kunal.springBootDependencyInjection.SpringApp.model.coach.FootballCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  //define a private field for the dependency
  private Coach cricketCoach;
  private Coach footballCoach;

  //define a constructor for dependency injection
  @Autowired
  DemoController(CricketCoach cricketcoach, FootballCoach footballCoach) {
    this.cricketCoach = cricketcoach;
    this.footballCoach = footballCoach;
  }

  @GetMapping("/dailyWorkoutCricket")
  public String getCricketWorkout() {
    return this.cricketCoach.getDailyWorkout();
  }

  @GetMapping("/dailyWorkoutFootball")
  public String getFootballWorkout() {
    return this.footballCoach.getDailyWorkout();
  }

}
