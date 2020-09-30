package Serialization;

import Animals.Animal;

import java.io.*;

public class AnimalSerializer {

    public static void saveAnimal(Animal animal){
        String path = "src/main/java/Data/animal.ser";
        ObjectOutputStream out;
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            if(Helper.doesFileExist(path)){
                out = new AppendingObjectOutputStream(fileOut);
            } else {
                out = new ObjectOutputStream(fileOut);
            }
            out.writeObject(animal);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in " + path);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Animal getAnimal(){
        Animal animal = null;
        try{
            FileInputStream fileIn = new FileInputStream("src/main/java/Data/animal.ser");
            ObjectInputStream in = new ObjectInputStream((fileIn));
            animal = (Animal) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("animal class not found");
            c.printStackTrace();
        }
        return animal;
    }
}
