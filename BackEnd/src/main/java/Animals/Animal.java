package Animals;

import Serialization.AnimalSerializer;

import java.time.LocalDate;

public abstract class Animal {

    abstract public String getName();

    abstract public Gender getGender();

    abstract public Reservor getReservedBy();

    abstract public Boolean reserve(String reservedBy);

    @Override
    public String toString(){
        String reserved = "not reserved";
        if(getReservedBy() != null){
            reserved = "reserved by " + getReservedBy().getName();
        }
        return getName() + ", " + getGender() + ", " + reserved;
    }

    public static Animal getAnimal(){
        return AnimalSerializer.getAnimal();
    }
}
