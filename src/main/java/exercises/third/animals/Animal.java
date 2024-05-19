package exercises.third.animals;

import exercises.third.animals.parts.Spine;

import java.util.Objects;

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

    public int getHeight() {
        return spine.length;
    }

    public void move() {
        System.out.println(name + " is moving");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(spine, animal.spine) && Objects.equals(habitat, animal.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, spine, habitat);
    }
}
