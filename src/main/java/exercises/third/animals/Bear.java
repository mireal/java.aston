package exercises.third.animals;

import exercises.third.animals.parts.Fur;

import java.util.Objects;

public class Bear extends Mammal {
    Fur fur;
    public Bear(String name, String habitat,String furColor ,int height) {
        super(name, habitat,height);
        fur = new Fur(furColor);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;

        Bear bear = (Bear) o;
        return (fur.color.equals(bear.fur.color));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fur);
    }
}
