package exercises.third.vehicles;

import exercises.third.vehicles.interfaces.Cargo;
import exercises.third.vehicles.interfaces.Propeller;

public class Boat extends Vehicle implements Cargo, Propeller {
    public Boat(String name) {
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
    public void spin() {
        System.out.println(name + "'s propeller are spinning");
    }
}
