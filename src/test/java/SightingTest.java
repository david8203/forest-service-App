import org.junit.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    public Sighting setupObject() {
        return new Sighting(1, "Ruaka", "David Ndungu");
    }

    @Test
    public void sighting_instantiatesCorrectly_true() {
        assertEquals(true, setupObject() instanceof Sighting);
    }
    @Test
    public void getAnimalId_sightingInstantiatesWithAnimalId_int() {
        assertEquals(1, setupObject().getAnimalId());
    }
    @Test
    public void getLocation_sightingInstantiatesWithLocation_string() {
        assertEquals("Ruaka", setupObject().getLocation());
    }
    @Test
    public void getRangerName_sightingInstantiatesWithRangerName_string() {
        assertEquals("David Ndungu", setupObject().getRangerName());
    }
    @Test
    public void equals_returnsTrueIfLocationAndAnimalIdAreSame_true() {
        Sighting firstSighting = new Sighting(1, "Ruaka", "Ben");
        Sighting secondSighting = new Sighting(1, "Ruaka", "Ben");
        assertTrue(firstSighting.equals(secondSighting));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Sighting() {
        setupObject().save();
        assertTrue(Sighting.all().get(0).equals(setupObject()));
    }
    @Test
    public void save_assignsIdToObject() {
        Sighting testSighting = new Sighting(1, "Ruaka", "Ben");
        testSighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(testSighting.getSightingId(), savedSighting.getSightingId());
    }
    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sighting firstSighting = new Sighting(1, "Ruaka", "Ben");
        firstSighting.save();
        Sighting secondSighting = new Sighting(56, "Ruaka", "Ruwel");
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }

}