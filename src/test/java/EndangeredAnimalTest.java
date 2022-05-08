import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndangeredAnimalTest {
    public EndangeredAnimal setupObject() {
        return new EndangeredAnimal("Lion", "okay", "newborn");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        assertEquals(true, setupObject() instanceof Animal);
    }
    @Test
    public void getName_endangeredAnimalInstantiatesWithName_Elephant() {
        assertEquals("Elephant", setupObject().getName());
    }
    @Test
    public void getHealth_endangeredAnimalInstantiatesWithHealth_okay() {
        assertEquals("okay", setupObject().getHealth());
    }
    @Test
    public void getAge_endangeredAnimalInstantiatesWithAge_newborn() {
        assertEquals("newborn", setupObject().getAge());
    }

}