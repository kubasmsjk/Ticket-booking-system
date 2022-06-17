import java.util.Objects;
import java.io.*;

public class Route implements Serializable {
    private int routeLenght;
    public Airport l1;
    public Airport l2;

    public Route(Airport l1, Airport l2, int routeLenght) {
        this.l1 = l1;
        this.l2 = l2;
        this.routeLenght = routeLenght;
    }

    public int getRouteLenght() {
        return routeLenght;
    }

    public Airport getL1() {
        return l1;
    }

    public Airport getL2() {
        return l2;
    }

    @Override
    public String toString() {
        return "Route{" +
                "departure: " + l1 +
                ", arrival " + l2 +
                ", routeLenght=" + routeLenght +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return routeLenght == route.routeLenght && Objects.equals(l1, route.l1) && Objects.equals(l2, route.l2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeLenght, l1, l2);
    }
}
