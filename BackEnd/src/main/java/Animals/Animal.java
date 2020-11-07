package Animals;

import Serialization.AnimalSerializer;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal implements ISellable {

    abstract public String getName();

    abstract public Gender getGender();

    abstract public Reservor getReservedBy();

    abstract public Boolean reserve(String reservedBy);

    abstract public String id();

    abstract public double getPrice();

    @Override
    public abstract void setPrice(double price);

    @Override
    public abstract void setName(String name);

    public abstract double calculatePrice();

    @Override
    public String toString(){
        String reserved = "not reserved";
        if(getReservedBy() != null){
            reserved = "reserved by " + getReservedBy().getName();
        }
        return getName() + ", " + getGender() + ", " + reserved + ", " + getPrice();
    }

    public static ArrayList<Animal> getAnimals(){
        return AnimalSerializer.getAnimals();
    }
}
