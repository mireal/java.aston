package exercises.second.vehicles;

import exercises.second.vehicles.interfaces.Cargo;
import exercises.second.vehicles.interfaces.Wheels;

public class Truck extends Vehicle implements Cargo, Wheels {
    public Truck(String name) {
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
}
