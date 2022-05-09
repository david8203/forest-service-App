import org.slf4j.LoggerFactory;
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
        Logger logger = (Logger) LoggerFactory.getLogger(DB.class);

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
            ((org.slf4j.Logger) logger).error("Unable to connect to database.");
        }
    }


    //development database
//    public static Sql2o sql2o = new Sql2o(
//            "jdbc:postgresql://localhost:5432/wildlife_tracker",
//            "dice",
//            "8203");
}
