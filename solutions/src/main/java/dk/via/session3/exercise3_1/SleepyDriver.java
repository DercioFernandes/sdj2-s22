package dk.via.session3.exercise3_1;

public class SleepyDriver implements TrafficLightObserver {
    private final Car car;

    public SleepyDriver(Car car) {
        this.car = car;
    }

    public void onLightChange(LightColor color) {
        switch(color) {
            case GREEN -> {
                car.start();
                car.accelerate();
            }
            case YELLOW -> {
                car.decelerate();
            }
            case RED -> {
                car.stop();
            }
            case RED_YELLOW -> {
            }
        }
    }
}
