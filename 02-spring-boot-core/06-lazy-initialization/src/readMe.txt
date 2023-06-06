Instead of creating beans up front, we can specify lazy initialization
A bean will only be initialized in the following cases
  It is depended for dependency injection
  Or it is explicitly requested
  We will simply add the @Lazy annotation to the class

  It is difficult and tedious to put @lazy annotation to all the class therefore we
  can set up in global config

  spring.main.lazy-initialization = true

Advantages:
  Only create objects as needed
  May help with faster startup time if you have larger no of components

Disadvantages:
  If you have web related components @RestController, not created until requested
  May not discover configuration issues util too late
  Need to make sure you have enough memory for all beans once created

  When we run application we see that all the objects beans are already created
  We get statements when we run app
      Inside CricketCoach
      Inside FootballCoach
      Inside BaseballCoach

  Now the above constructor only appears if we hit the api i.e
      Inside CricketCoach
      Inside FootballCoach
      Inside BaseballCoach
