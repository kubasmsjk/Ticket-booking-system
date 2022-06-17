import java.util.Objects;
import java.io.*;

public class IndividualClient extends Client implements Serializable {

    private String name;
    private String surname;
    private String PESEL;

    public IndividualClient(String name, String surname, String PESEL) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
    }

    public IndividualClient() {
        name = "unknown";
        surname = "unknown";
        PESEL = "00000000000";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getPESEL() {
        return PESEL;
    }

    @Override
    public String toString() {
        return "IndividualClient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", PESEL='" + PESEL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndividualClient that = (IndividualClient) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(PESEL, that.PESEL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, PESEL);
    }
}
