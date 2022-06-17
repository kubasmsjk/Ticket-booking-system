import java.util.Objects;
import java.io.*;

public class Airplane implements Serializable {
    private String name;
    private int range;
    private int numberOfSeats;
    private boolean status = true;

    public Airplane(String name, int range, int numberOfSeats, boolean status) {
        this.name = name;
        this.range = range;
        this.numberOfSeats = numberOfSeats;
        this.status = status;
    }

    public Airplane() {
        name = "unknown";
        range = 0;
        numberOfSeats = 0;
        status = false;
    }

    public String getName() {
        return name;
    }

    public int getRange() {
        return range;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "name='" + name + '\'' +
                ", range=" + range +
                ", numberOfSeats=" + numberOfSeats +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return range == airplane.range && numberOfSeats == airplane.numberOfSeats && status == airplane.status && Objects.equals(name, airplane.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, range, numberOfSeats, status);
    }

}
