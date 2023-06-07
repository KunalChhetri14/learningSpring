package com.kunal.springBootDependencyInjection.SpringApp.config;

import com.kunal.springBootDependencyInjection.SpringApp.model.coach.Coach;
import com.kunal.springBootDependencyInjection.SpringApp.model.coach.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

  @Bean("swimObj")
  public Coach swimCoach() {
    return new SwimCoach();
  }
}
