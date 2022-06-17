import java.io.Serializable;
import java.util.Objects;

public class Airport implements Serializable {
    private String airportName;


    public Airport(String airportName) {
        this.airportName = airportName;
    }


    public Airport() {
        airportName = "unknown";
    }

    public String getAirportName() {
        return airportName;
    }

    @Override
    public String toString() {
        return  airportName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airportName, airport.airportName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportName);
    }
}
