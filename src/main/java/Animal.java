import java.util.Objects;

public abstract class Animal {
    public int id;
    public String name;
    public boolean endangered;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEndangered() {
        return endangered;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
