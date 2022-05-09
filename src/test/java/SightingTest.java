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


}