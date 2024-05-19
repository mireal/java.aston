package exercises.second.animals;

import exercises.second.animals.parts.Fur;

public class Cat extends Mammal {
    Fur fur;
    public Cat(String name, String habitat,String furColor ,int height) {
        super(name, habitat,height);
        fur = new Fur(furColor);
    }
}
