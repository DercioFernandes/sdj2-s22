package dk.via.session3.exercise3_1;

public class Pedestrian implements TrafficLightObserver {
    public void onLightChange(LightColor color) {
        switch(color) {
            case GREEN -> {
                System.out.println("Wait");
            }
            case YELLOW -> {
                System.out.println("Run");
            }
            case RED -> {
                System.out.println("Walk");
            }
            case RED_YELLOW -> {
                System.out.println("Get ready");
            }
        }
    }
}
