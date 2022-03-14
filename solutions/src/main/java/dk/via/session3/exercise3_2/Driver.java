package dk.via.session3.exercise3_2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Driver implements PropertyChangeListener {
    private final Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void onLightChange(LightColor color) {
        switch(color) {
            case GREEN -> {
                if (!car.isRunning()) car.start();
                car.accelerate();
            }
            case YELLOW -> {
                car.decelerate();
            }
            case RED -> {
                car.stop();
            }
            case RED_YELLOW -> {
                car.start();
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        onLightChange((LightColor) evt.getNewValue());
    }
}
