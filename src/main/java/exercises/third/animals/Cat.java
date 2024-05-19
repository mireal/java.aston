package exercises.third.animals;

import exercises.third.animals.parts.Fur;

import java.util.Objects;

public class Cat extends Mammal {
    Fur fur;
    public Cat(String name, String habitat,String furColor ,int height) {
        super(name, habitat,height);
        fur = new Fur(furColor);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(fur, cat.fur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fur);
    }
}
