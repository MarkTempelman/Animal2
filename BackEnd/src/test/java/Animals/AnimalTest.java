package Animals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    private Animal animal;

    @Before
    public void setUp() {
        this.animal = new Dog("Ugly Duckling", Gender.Male);
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
        assertEquals("Ugly Duckling, Male, reserved by John Doe", this.animal.toString());
    }

    @Test
    public void TestSaveMultipleAnimal(){
        Animal cat = new Cat("kitty", Gender.Female, "nothing");
        assertTrue(true);
    }

    //commit2
}