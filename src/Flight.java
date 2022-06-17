import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.io.*;

public class Flight implements Serializable {
    private Route r;
    private Airplane p;
    private LocalDateTime hoursOfDepartue;
    private LocalDateTime hoursOfArrival;
    private LocalDate dateOfArrival;
    private LocalDate dateOfDepartue;

    public Flight() {
        r = null;
        p = null;
        hoursOfDepartue = null;
        hoursOfArrival = null;
        dateOfArrival = null;
        dateOfDepartue = null;
    }

    public Flight(Route r, Airplane p, LocalDateTime hoursOfDepartue, LocalDateTime hoursOfArrival, LocalDate dateOfArrival, LocalDate dateOfDepartue) {
        this.r = r;
        this.p = p;
        this.hoursOfDepartue = hoursOfDepartue;
        this.hoursOfArrival = hoursOfArrival;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDepartue = dateOfDepartue;
    }

    public Route getR() {
        return r;
    }

    public void setR(Route r) {
        this.r = r;
    }

    public Airplane getP() {
        return p;
    }

    public void setP(Airplane p) {
        this.p = p;
    }

    public LocalDateTime getHoursOfDepartue() {
        return hoursOfDepartue;
    }

    public void setHoursOfDepartue(LocalDateTime hoursOfDepartue) {
        this.hoursOfDepartue = hoursOfDepartue;
    }

    public LocalDateTime getHoursOfArrival() {
        return hoursOfArrival;
    }

    public void setHoursOfArrival(LocalDateTime hoursOfArrival) {
        this.hoursOfArrival = hoursOfArrival;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public LocalDate getDateOfDepartue() {
        return dateOfDepartue;
    }

    public void setDateOfDepartue(LocalDate dateOfDepartue) {
        this.dateOfDepartue = dateOfDepartue;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "r=" + r + "\n" +
                ", p=" + p + "\n" +
                ", hoursOfDepartue=" + hoursOfDepartue + "\n" +
                ", hoursOfArrival=" + hoursOfArrival + "\n" +
                ", dateOfArrival=" + dateOfArrival + "\n" +
                ", dateOfDepartue=" + dateOfDepartue + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(r, flight.r) && Objects.equals(p, flight.p) && Objects.equals(hoursOfDepartue, flight.hoursOfDepartue) && Objects.equals(hoursOfArrival, flight.hoursOfArrival) && Objects.equals(dateOfArrival, flight.dateOfArrival) && Objects.equals(dateOfDepartue, flight.dateOfDepartue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, p, hoursOfDepartue, hoursOfArrival, dateOfArrival, dateOfDepartue);
    }
}
