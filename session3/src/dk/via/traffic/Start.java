package dk.via.traffic;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        Thread lightThread = new Thread(light);
        lightThread.start();
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Car carT = new Car("T");
        Driver driverA = new Driver(carA);
        Driver driverB = new Driver(carB);
        Driver driverC = new Driver(carC);
        TaxiDriver taxiDriver = new TaxiDriver(carT);
        carA.start();
        carB.start();
        carC.start();
        carT.start();
        Thread.sleep(1000);
        light.addObserver(driverA);
        light.addObserver(driverB);
        Thread.sleep(2000);
        light.addObserver(driverC);
        light.addObserver(taxiDriver);
    }
}
