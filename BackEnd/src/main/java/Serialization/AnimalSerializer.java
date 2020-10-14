package Serialization;

import Animals.Animal;

import java.io.*;
import java.util.ArrayList;

public class AnimalSerializer {

    public static void saveAnimal(Animal animal){
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(animal);

        File f = new File("animalData");
        if(f.exists()){
            animals.addAll(getAnimals());
        }
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("animalData");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(animals);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public static void saveAllAnimals(ArrayList<Animal> animals){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("animalData");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(animals);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public static ArrayList<Animal> getAnimals(){
        ArrayList<Animal> animals = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("animalData");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            animals = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("animal class not found");
            c.printStackTrace();
        }
        return animals;
    }
}
