package dk.via.exercise6_1;

public class Yellow implements TrafficLightState {
    private final TrafficLight trafficLight;

    public Yellow(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void next() {
        trafficLight.turnOff(Lights.GREEN);
        trafficLight.turnOn(Lights.RED);
        trafficLight.setState(new Red(trafficLight));
    }
}
