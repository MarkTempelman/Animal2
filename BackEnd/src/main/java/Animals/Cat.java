package Animals;

public class Cat extends Animal implements java.io.Serializable{
    private String _badHabits;
    private String _name;
    private Gender _gender;
    private Reservor _reservedBy;

    public Cat(String name, Gender gender, String badHabits)
    {
        _badHabits = badHabits;
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

    @Override
    public String toString(){
        return super.toString() + String.format(", bad habits: %h", _badHabits.toLowerCase());
    }
}
