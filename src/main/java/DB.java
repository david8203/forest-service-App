

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;


public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;

    static {
        Logger logger = Logger.getLogger(String.valueOf(DB.class));

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://localhost:5432/wildlife_tracker");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }
            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? DatabaseProps.username : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? DatabaseProps.password : dbUri.getUserInfo().split(":")[1];
            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e ) {
            logger.log(Level.WARNING,"not connected to a database");
        }
    }

}
//development database
//    public static Sql2o sql2o = new Sql2o(
//            "jdbc:postgresql://localhost:5432/wildlife_tracker",
//            "dice",
//            "8203");
