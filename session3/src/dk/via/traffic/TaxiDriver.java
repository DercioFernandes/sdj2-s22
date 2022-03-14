package dk.via.traffic;

public class TaxiDriver extends Driver
{
  public TaxiDriver(Car car)
  {
    super(car);
  }

  public void onLightChange(LightColor color) {
    switch(color) {
      case GREEN -> {
        if (!getCar().isRunning()) getCar().start();
        getCar().accelerate();
      }
      case YELLOW -> {
      }
      case RED -> {
        getCar().stop();
      }
      case RED_YELLOW -> {
        getCar().start();
      }
    }
  }

}
