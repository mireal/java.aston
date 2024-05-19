package exercises.second.vehicles;

abstract class Vehicle {
    String name;
    Vehicle(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println(name + " is moving");
    }
}
