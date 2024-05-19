package exercises.third;

import exercises.third.animals.Bear;
import exercises.third.animals.Cat;
import exercises.third.animals.Fish;
import exercises.third.animals.Whale;
import exercises.third.vehicles.*;

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
        tanker.loadCargo();

        Cat cat = new Cat("Oliver", "home", "black", 40);
        cat.move();
        System.out.println();

        Bear bear = new Bear("Bear", "forest", "brown", 200);
        bear.breastfeed();

        Whale whale = new Whale("Whale", "Water", 1000);
        System.out.println(whale.getName() + " lives in " + whale.getHabitat());

        Fish fish = new Fish("Fish", "Water", 10);
        fish.move();
        System.out.println(fish.getName() + " size is " + fish.getHeight());
    }
}
