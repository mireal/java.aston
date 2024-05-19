package exercises.third.vehicles;

import java.util.Objects;

abstract class Vehicle {
    String name;
    Vehicle(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println(name + " is moving");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
