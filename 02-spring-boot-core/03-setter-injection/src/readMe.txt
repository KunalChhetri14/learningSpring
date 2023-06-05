For setter injection

@Autowired
public void setCricket(Cricket coach) {
  this.cricketCoach = coach
}

setCricket can be replaced with Name

For field injection we can directly use
@Autowired
CricketCoach cricket;
This is not advisable as it makes unit test difficult
