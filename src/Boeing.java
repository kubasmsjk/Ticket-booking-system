import java.util.Objects;
import java.io.*;

public class Boeing extends Airplane implements Serializable {
    String name;
    int range;
    int numberOfSeats;
    boolean status = true;

    public Boeing(String name, int range, int numberOfSeats, boolean status) {
        this.name = name;
        this.range = range;
        this.numberOfSeats = numberOfSeats;
        this.status = status;
    }

    public Boeing() {
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
        return "Boeing{" +
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
        Boeing boeing = (Boeing) o;
        return range == boeing.range && numberOfSeats == boeing.numberOfSeats && status == boeing.status && Objects.equals(name, boeing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, range, numberOfSeats, status);
    }
}



