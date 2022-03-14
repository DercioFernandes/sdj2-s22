package dk.via.exercise6_1;

public class TrafficLight {
    private final Lights lights;
    private TrafficLightState state;

    public TrafficLight() {
        lights = new Lights();
        lights.turnOn(Lights.RED);
        lights.printLights();
        state = new Red(this);
    }

    void setState(TrafficLightState state) {
        this.state = state;
        lights.printLights();
    }

    public void next() {
        state.next();
    }

    void turnOn(String... lights) {
        this.lights.turnOn(lights);
    }

    void turnOff(String... lights) {
        this.lights.turnOff(lights);
    }
}
