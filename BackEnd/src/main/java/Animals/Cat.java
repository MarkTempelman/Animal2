package Animals;

public class Cat extends Animal implements java.io.Serializable{
    private String _badHabits;

    private String _name;
    private Gender _gender;
    private Reservor _reservedBy;
    private double _price;

    public Cat(String name, Gender gender, String badHabits)
    {
        _name = name;
        _gender = gender;
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
    public String id() {
        return null;
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
        double currentPrice = 350 - (20 * _badHabits.length());
        if(currentPrice < 35) return 35;
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

    @Override
    public String toString(){
        return super.toString() + String.format(", bad habits: " + _badHabits.toLowerCase());
    }
}
