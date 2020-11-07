package Serialization;

import Animals.Animal;

import java.util.ArrayList;

public interface IAnimalSerializer {
    void saveAnimal(Animal animal);
    void saveAllAnimals(ArrayList<Animal> animals);
    ArrayList<Animal> getAnimals();
}
