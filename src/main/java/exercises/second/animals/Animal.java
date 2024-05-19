package exercises.second.animals;

import exercises.second.animals.parts.Spine;

abstract class Animal {
    final private String name;
    final private Spine spine;
    final private String habitat;

    Animal(String name, String habitat, int spineLength) {
        this.name = name;
        this.habitat = habitat;
        this.spine = new Spine(spineLength);
    }

    public String getName() {
        return name;
    }

    public String getHabitat() {
        return habitat;
    }

    public void move() {
        System.out.println(name + " is moving");
    }
}
