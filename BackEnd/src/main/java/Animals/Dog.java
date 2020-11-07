package Animals;

import Serialization.AnimalSerializer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

public class Dog extends Animal implements java.io.Serializable{
    private LocalDateTime _lastWalk;

    private String _name;
    private Gender _gender;
    private Reservor _reservedBy;
    private String _id;
    private double _price;

    public Dog(String name, Gender gender) {
        _name = name;
        _gender = gender;
        _lastWalk = LocalDateTime.now();
        _id = UUID.randomUUID().toString();
    }

    public LocalDateTime getLastWalk(){
        return _lastWalk;
    }

    @Override
    public Boolean reserve(String reservedBy){
        if(_reservedBy == null){
            _reservedBy = new Reservor(reservedBy, java.time.LocalDateTime.now());
            return true;
        }
        return false;
    }

    @Override
    public String id() {
        return _id;
    }

    @Override
    public double getPrice() {
        return _price;
    }

    @Override
    public void setPrice(double price) {
        _price = price;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public double calculatePrice() {
        ArrayList<Animal> animals = (ArrayList<Animal>) Animal.getAnimals().stream().filter(
                x -> x.getClass().getName() == this.getClass().getName())
                .collect(Collectors.toList());
        double currentPrice = 500 - (50 * animals.size());
        if(currentPrice < 50) return 50;
        return currentPrice;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public Gender getGender() {
        return _gender;
    }

    @Override
    public Reservor getReservedBy() {
        return _reservedBy;
    }
}
