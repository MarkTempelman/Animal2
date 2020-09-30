package Reservation;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Gender;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private List<Animal> _animals = new ArrayList<Animal>();

    public List<Animal> getAnimals(){
        return _animals;
    }

    public void newCat(String name, Gender gender, String badHabits){
        _animals.add(new Cat(name, gender, badHabits));
    }

    public void newDog(String name, Gender gender){
        _animals.add(new Dog(name, gender));
    }
}
