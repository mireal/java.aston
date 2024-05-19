package exercises.third.vehicles;

import exercises.third.vehicles.interfaces.Cargo;
import exercises.third.vehicles.interfaces.Propeller;
import exercises.third.vehicles.interfaces.Wheels;
import exercises.third.vehicles.interfaces.Wings;

public class Plane extends Vehicle implements Cargo, Propeller, Wheels, Wings {
    public Plane(String name) {
        super(name);
    }

    @Override
    public void loadCargo() {
        System.out.println("Cargo loaded");
    }

    @Override
    public void unloadCargo() {
        System.out.println("Cargo unloaded");
    }

    @Override
    public void drive() {
        System.out.println(name + "'s wheels are spinning");
    }

    @Override
    public void spin() {
        System.out.println(name + "'s propeller are spinning");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }
}
