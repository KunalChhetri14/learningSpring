If there is multiple implementation child class then we can use @qualifier to differentiate
but we can also provide default child class if not mentioned using @primary annotaion


@Component
@Primary
public class CricketCoach implements Coach{
  @Override
  public String getDailyWorkout() {
    return "Cricket:: Treadmill for 15 mins twice, weihted exercise for 30 mins twice";
  }
}

we cannoot define two primary else it shows error that two primary found
