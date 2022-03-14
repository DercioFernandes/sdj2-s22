package dk.via.session3.exercise3_1;

public class TaxiDriver implements TrafficLightObserver {
    private final Car car;

    public TaxiDriver(Car car) {
        this.car = car;
    }

    public void onLightChange(LightColor color) {
        switch(color) {
            case GREEN -> {
                if (!car.isRunning()) car.start();
                car.accelerate();
            }
            case YELLOW -> {
                // Do nothing
            }
            case RED -> {
                car.stop();
            }
            case RED_YELLOW -> {
                car.start();
            }
        }
    }
}
