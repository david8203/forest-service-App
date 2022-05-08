import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonAnimalTest {
    public CommonAnimal setupObject() {
        return new CommonAnimal("Lion");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void commonAnimal_instantiatesCorrectly_true() {
        assertEquals(true, setupObject() instanceof CommonAnimal);
    }
    @Test
    public void getName_commonAnimalInstantiatesWithName_Elephant() {
        assertEquals("Lion", setupObject().getName());
    }
    @Test
    public void equals_returnsTrueIfNameIsSame_true() {
        CommonAnimal firstCommonAnimal = new CommonAnimal("Lion");
        CommonAnimal anotherCommonAnimal = new CommonAnimal("Lion");
        assertTrue(firstCommonAnimal.equals(anotherCommonAnimal));
    }
    @Test
    public void save_insertsObjectIntoDatabase_CommonAnimal() {
        setupObject().saveCommonAnimal();
        assertTrue(CommonAnimal.all().get(0).equals(setupObject()));
    }

}