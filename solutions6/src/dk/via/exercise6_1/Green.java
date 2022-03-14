package dk.via.exercise6_1;

public class Green implements TrafficLightState {
    private final TrafficLight trafficLight;

    public Green(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void next() {
        trafficLight.turnOff(Lights.GREEN);
        trafficLight.turnOn(Lights.YELLOW);
        trafficLight.setState(new Yellow(trafficLight));
    }
}
