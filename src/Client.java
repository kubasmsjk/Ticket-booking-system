import java.io.*;

public class Client implements Serializable {
    private String name;
    private String surname;
    private String PESEL;

    public Client(String name, String surname, String PESEL) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
    }

    public Client() {
        name = "unknown";
        surname = "unknown";
        PESEL = "00000000000";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String toString() {
        return "Dane Klienta:" + "\n" + "Imie: " + name + "\n" + "Nazwisko: " + surname + "\n" + "PESEL: " + PESEL;
    }

}
