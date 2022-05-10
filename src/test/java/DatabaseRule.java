import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource{
    @Override
    protected void before() {
        //development database
//        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "kingdice", "8203");  //Those with linux or windows use two strings for username and password
//    }

    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "owfozlaliwbcvu", "7e516450d6db0f4ccf2c198a7319b25984c49315e8ea6e7b063bcd80b26c665a");  //Those with linux or windows use two strings for username and password
}

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {

            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String resetSightingsId = "ALTER SEQUENCE sightings_sighting_id_seq RESTART WITH 1;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";


            String resetAnimalsId = "ALTER SEQUENCE animals_id_seq RESTART WITH 1;";

            con.createQuery(resetAnimalsId).executeUpdate();
            con.createQuery(resetSightingsId).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
            con.createQuery(deleteAnimalsQuery).executeUpdate();


        }
    }

}