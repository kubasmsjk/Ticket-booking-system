import java.io.*;
import java.util.Objects;

public class Ticket implements Serializable{
    public IntermediaryCompany ic;
    public Client c;
    public Flight f;

    public Ticket() {
        ic = null;
        c = null;
        f = null;
    }

    public Ticket(IntermediaryCompany ic, Client c, Flight f) {
        this.ic = ic;
        this.c = c;
        this.f = f;
    }

    public IntermediaryCompany getIc() {
        return ic;
    }

    public void setIc(IntermediaryCompany ic) {
        this.ic = ic;
    }

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public Flight getF() {
        return f;
    }

    public void setF(Flight f) {
        this.f = f;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ic=" + ic +
                ", c=" + c +
                ", f=" + f +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ic, ticket.ic) && Objects.equals(c, ticket.c) && Objects.equals(f, ticket.f);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ic, c, f);
    }
}
