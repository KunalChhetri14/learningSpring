If there is multiple implementation child class then we can use @qualifier to differentiate

@Autowired
  DemoController(@Qualifier("cricketCoach") Coach cricketCoachObj, Coach footballCoach) {
    this.cricketCoachObj = cricketCoachObj;
    this.footballCoach = footballCoachObj;
  }

  //by default footballCoach will assume as footballCoach object but it is alwasy recommended to use
  //@Qualifier
