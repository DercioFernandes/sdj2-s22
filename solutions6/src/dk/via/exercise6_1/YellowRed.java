package dk.via.exercise6_1;

public class YellowRed implements TrafficLightState {
    private final TrafficLight trafficLight;

    public YellowRed(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void next() {
        trafficLight.turnOff(Lights.RED, Lights.YELLOW);
        trafficLight.turnOn(Lights.GREEN);
        trafficLight.setState(new Green(trafficLight));
    }
}
