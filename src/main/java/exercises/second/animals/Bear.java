package exercises.second.animals;

import exercises.second.animals.parts.Fur;

public class Bear extends Mammal {
    Fur fur;
    public Bear(String name, String habitat,String furColor ,int height) {
        super(name, habitat,height);
        fur = new Fur(furColor);
    }
}
