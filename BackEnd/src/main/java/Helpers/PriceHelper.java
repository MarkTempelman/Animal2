package Helpers;

import Animals.Animal;
import Serialization.IAnimalSerializer;

import java.util.stream.Collectors;

public class PriceHelper {
    private static IAnimalSerializer animalSerializer;

    public static void setAnimalSerializer(IAnimalSerializer animalSerializer) {
        PriceHelper.animalSerializer = animalSerializer;
    }

    public static int getDogCount(){
        return Animal.getAnimals(animalSerializer).stream().filter(
                x -> x.getClass().getName() == "Animals.Dog")
                .collect(Collectors.toList()).size();
    }
}
