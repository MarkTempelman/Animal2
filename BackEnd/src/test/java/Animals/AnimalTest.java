package Animals;

import Serialization.IAnimalSerializer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    private Animal animal;
    private IAnimalSerializer animalSerializer;

    @Before
    public void setUp() {
        animalSerializer = new MockAnimalSerializer();
        this.animal = new Dog("Ugly Duckling", Gender.Male, animalSerializer);
    }

    @Test
    public void TestConstructor() {
        assertEquals("Ugly Duckling", this.animal.getName());
        assertEquals(Gender.Male, this.animal.getGender());
        assertNull(this.animal.getReservedBy());
    }

    @Test
    public void TestReservation(){
        assertNull(this.animal.getReservedBy());
        assertTrue(this.animal.reserve("John Doe"));
        assertNotNull(this.animal.getReservedBy());
        assertEquals("John Doe", this.animal.getReservedBy().getName());
        assertFalse(this.animal.reserve("Jane Doe"));
    }

    @Test
    public void TestToString(){
        this.animal.reserve("John Doe");
        assertEquals("Ugly Duckling, Male, reserved by John Doe, 0.0", this.animal.toString());
    }

    @Test
    public void TestCalculateCatPriceNoBadHabits(){
        Animal cat = new Cat("name", Gender.Male, "");
        double expected = 350;
        double actual = cat.calculatePrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void TestCalculateCatPriceOneBadHabit(){
        Animal cat = new Cat("name", Gender.Male, "f");
        double expected = 330;
        double actual = cat.calculatePrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void TestCalculateCatPriceFourBadHabits(){
        Animal cat = new Cat("name", Gender.Male, "test");
        double expected = 270;
        double actual = cat.calculatePrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void TestCalculateCatPriceMinimumPrice(){
        Animal cat = new Cat("name", Gender.Male, "this is a test for the minimum price");
        double expected = 35;
        double actual = cat.calculatePrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void TestCalculateDogPriceMaximumPrice(){
        double expected = 500;
        double actual = animal.calculatePrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void TestCalculateDogPriceSecondDog(){
        double expected = 450;
        animalSerializer.saveAnimal(animal);
        Animal dog = new Dog("name", Gender.Male, animalSerializer);
        double actual = dog.calculatePrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void TestCalculateDogPriceThirdDog(){
        double expected = 400;

        animalSerializer.saveAnimal(animal);
        Animal dog1 = new Dog("name", Gender.Male, animalSerializer);
        animalSerializer.saveAnimal(dog1);
        Animal dog2 = new Dog("name", Gender.Male, animalSerializer);

        double actual = dog2.calculatePrice();
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void TestCalculateDogPriceMinimumPrice(){
        double expected = 50;

        for(int i = 0; i < 10; i++){
            animalSerializer.saveAnimal(new Dog("name" + i, Gender.Male, animalSerializer));
        }

        Animal dog = new Dog("name", Gender.Male, animalSerializer);
        double actual = dog.calculatePrice();

        assertEquals(expected, actual, 0.1);
    }
}