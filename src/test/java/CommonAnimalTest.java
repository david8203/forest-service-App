//import org.junit.Rule;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CommonAnimalTest {
//    public CommonAnimal setupObject() {
//        return new CommonAnimal("Lion");
//    }
//
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void commonAnimal_instantiatesCorrectly_true() {
//        assertEquals(true, setupObject() instanceof CommonAnimal);
//    }
//    @Test
//    public void getName_commonAnimalInstantiatesWithName_Elephant() {
//        assertEquals("Lion", setupObject().getName());
//    }
//    @Test
//    public void equals_returnsTrueIfNameIsSame_true() {
//        CommonAnimal firstCommonAnimal = new CommonAnimal("Lion");
//        CommonAnimal anotherCommonAnimal = new CommonAnimal("Lion");
//        assertTrue(firstCommonAnimal.equals(anotherCommonAnimal));
//    }
//    @Test
//    public void save_insertsObjectIntoDatabase_CommonAnimal() {
//        setupObject().saveCommonAnimal();
//        assertTrue(CommonAnimal.all().get(0).equals(setupObject()));
//    }
//    @Test
//    public void all_returnsAllInstancesOfCommonAnimal_true() {
//        CommonAnimal firstCommonAnimal = new CommonAnimal("Lion");
//        firstCommonAnimal.saveCommonAnimal();
//        CommonAnimal secondCommonAnimal = new CommonAnimal("Lion");
//        secondCommonAnimal.saveCommonAnimal();
//        assertEquals(true, CommonAnimal.all().get(0).equals(firstCommonAnimal));
//        assertEquals(true, CommonAnimal.all().get(1).equals(secondCommonAnimal));
//    }
//    @Test
//    public void save_assignsIdToObject() {
//        CommonAnimal testCommonAnimal = new CommonAnimal("Lion");
//        testCommonAnimal.saveCommonAnimal();
//        CommonAnimal savedCommonAnimal = CommonAnimal.all().get(0);
//        assertEquals(testCommonAnimal.getId(), savedCommonAnimal.getId());
//    }
//    @Test
//    public void find_returnsCommonWithSameId_secondCommonAnimal() {
//        CommonAnimal firstCommonAnimal = new CommonAnimal("Elephant");
//        firstCommonAnimal.saveCommonAnimal();
//        CommonAnimal secondCommonAnimal = new CommonAnimal("Elephant");
//        secondCommonAnimal.saveCommonAnimal();
//        assertEquals(CommonAnimal.find(secondCommonAnimal.getId()), secondCommonAnimal);
//    }
//
//    @Test
//    public void commonAnimal_instantiatesWithEndangeredFalse_false() {
//        CommonAnimal testCommonAnimal = setupObject();
//        assertEquals(testCommonAnimal.isEndangered(), false);
//    }
//}