package Animals;

import Serialization.IAnimalSerializer;

import java.util.ArrayList;

public class MockAnimalSerializer implements IAnimalSerializer {
    ArrayList<Animal> animals = new ArrayList<>();

    @Override
    public void saveAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void saveAllAnimals(ArrayList<Animal> animals) {
        animals = animals;
    }

    @Override
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
