package exercises.third.vehicles;

import exercises.third.vehicles.interfaces.Wheels;

public class Taxi extends Vehicle implements Wheels {
    public Taxi(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println(name + "'s wheels are spinning");
    }
}
