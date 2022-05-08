import org.sql2o.Connection;

public class EndangeredAnimal  extends Animal{
    private  String health;
    private String age;
    public static final boolean DATABASE_ENDANGERED = true;

    public EndangeredAnimal(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age;
        endangered = DATABASE_ENDANGERED;
    }

    public String getHealth() {
        return this.health;
    }

    public String getAge() {
        return age;
    }


    public void saveEndangeredAnimal() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, endangered, health, age) VALUES (:name, :endangered, :health, :age);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("endangered", this.endangered)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();

        }
    }

}
