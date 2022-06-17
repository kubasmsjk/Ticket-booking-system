import java.util.Objects;
import java.io.*;

public class Airbus extends Airplane implements Serializable {
    String name;
    int range;
    int numberOfSeats;
    boolean status = true;

    public Airbus(String name, int range, int numberOfSeats, boolean status) {
        this.name = name;
        this.range = range;
        this.numberOfSeats = numberOfSeats;
        this.status = status;
    }

    public Airbus() {
        name = "unknown";
        range = 0;
        numberOfSeats = 0;
        status = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Airbus{" +
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
        if (!super.equals(o)) return false;
        Airbus airbus = (Airbus) o;
        return range == airbus.range && numberOfSeats == airbus.numberOfSeats && status == airbus.status && Objects.equals(name, airbus.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, range, numberOfSeats, status);
    }
}


