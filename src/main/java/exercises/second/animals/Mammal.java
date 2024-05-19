package exercises.second.animals;

abstract class Mammal extends Animal {
    Mammal(String name, String habitat, int spineLength) {
        super(name, habitat, spineLength);
    }

    public void breastfeed() {
        System.out.println(getName() + " feeding baby");
    }
}
