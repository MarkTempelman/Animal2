package Animals;

import Serialization.AnimalSerializer;

import java.time.LocalDateTime;

public class Dog extends Animal implements java.io.Serializable{
    private LocalDateTime _lastWalk;

    private String _name;
    private Gender _gender;
    private Reservor _reservedBy;

    public Dog(String name, Gender gender) {
        _name = name;
        _gender = gender;
        _lastWalk = LocalDateTime.now();
        AnimalSerializer.saveAnimal(this);
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
