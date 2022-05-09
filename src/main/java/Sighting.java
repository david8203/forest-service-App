import org.sql2o.Connection;

public class Sighting {
    private int animal_id;
    private int sighting_id;
    private String location;
    private String ranger_name;

    public Sighting(int animal_id, String location, String ranger_name) {
        this.animal_id = animal_id;
        this.location = location;
        this.ranger_name = ranger_name;
    }

    public int getAnimalId() {
        return animal_id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return ranger_name;
    }

    public int getSightingId() {
        return this.sighting_id;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animal_id, location, ranger_name) VALUES (:animal_id, :location, :ranger_name);";
            this.sighting_id = (int) con.createQuery(sql, true)
                    .addParameter("animal_id", this.animal_id)
                    .addParameter("location", this.location)
                    .addParameter("ranger_name", this.ranger_name)
                    .executeUpdate()
                    .getKey();
        }
    }
}
