package exercises.second;

import exercises.second.animals.*;
import exercises.second.vehicles.*;

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck("Truck");
        truck.drive();

        Plane plane = new Plane("Boeing");
        plane.fly();

        Boat boat = new Boat("Boat");
        boat.spin();

        Taxi taxi = new Taxi("Yandex taxi");
        taxi.move();

        Helicopter heli = new Helicopter("Helicopter");
        heli.unloadCargo();

        Tanker tanker = new Tanker("Evergreen");
        tanker.move();

        Cat cat = new Cat("Oliver", "home", "black", 40);
        cat.move();
    }
}
