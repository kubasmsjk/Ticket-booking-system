import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

public class Main {
    static void console(AirportCompany a) {
        System.out.println("Witamy w panelu rezerwacji biletow.");
        System.out.println("1.Loty");
        System.out.println("2.Samoloty");
        System.out.println("3.Trasy i Lotniska");
        System.out.println("4.Klienci");
        System.out.println("5.Rezerwacja biletu");
        System.out.println("0.Wyjdz");
        a.checkFlight();
    }

    static void firstChoice(AirportCompany a) {
        System.out.println("1.Dodaj lot");
        System.out.println("2.Usun lot");
        System.out.println("3.Przegladaj lot");
        System.out.println("0.Powrot do menu glownego");
        Scanner scan = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Wybierz trase");
                a.showRoute();
                choice = scan.nextInt();
                System.out.println("Podaj godzine wylotu");
                int hour = scann.nextInt();
                System.out.println("Podaj minute wylotu");
                int minute = scann.nextInt();
                System.out.println("Podaj dzien odlotu");
                int day = scann.nextInt();
                System.out.println("Podaj miesiac odlotu");
                int month = scann.nextInt();
                System.out.println("Podaj rok wylotu");
                int year = scann.nextInt();
                LocalDate dateOfDepartue = LocalDate.of(year, month, day);
                LocalDateTime hoursOfDepartue = dateOfDepartue.atTime(hour, minute, 0);
                System.out.println("Podaj godzine przylotu");
                hour = scann.nextInt();
                System.out.println("Podaj minute przylotu");
                minute = scann.nextInt();
                System.out.println("Podaj dzien przylotu");
                day = scann.nextInt();
                System.out.println("Podaj miesiac przylotu");
                month = scann.nextInt();
                System.out.println("Podaj rok przylotu");
                year = scann.nextInt();
                LocalDate dateOfArrival = LocalDate.of(year, month, day);
                LocalDateTime hoursOfArrival = dateOfArrival.atTime(hour, minute, 0);
                if (hoursOfDepartue.isAfter((LocalDateTime.now())) && (dateOfDepartue.isBefore((dateOfArrival)) || dateOfDepartue.isEqual((dateOfArrival)))) {
                    Route r = a.routesList.get(choice);
                    Airplane p = a.comparisonRouteLenghtToRange(r.getRouteLenght(), a.airplaneList);
                    Flight f = new Flight(r, p, hoursOfDepartue, hoursOfArrival, dateOfArrival, dateOfDepartue);
                    a.addFlight(f);
                    firstChoice(a);
                } else {
                    System.out.println("Blad podania daty lub godziny");
                    firstChoice(a);
                }
                break;
            case 2:
                System.out.println("Podaj numer lotu, ktory chcesz usunac");
                int numberOfFlightToRemove = scann.nextInt();
                a.removeFlight(numberOfFlightToRemove);
                firstChoice(a);
                break;
            case 3:
                a.showFlight();
                firstChoice(a);
                break;
            case 0:
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void secondChoice(AirportCompany a) {
        System.out.println("1.Dodaj samolot");
        System.out.println("2.Usun samolot");
        System.out.println("3.Przegladaj samoloty");
        System.out.println("0.Powrot do menu glownego");
        Scanner scan = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Dostepne typy samolotow:");
                System.out.println("1.Boeing");
                System.out.println("2.Tupolew");
                System.out.println("3.Airbus");
                System.out.println("0.Powrot do menu glownego");
                System.out.println("Podaj typ samolotu ktory chcesz dodac");
                AirplaneChoice(a);
                break;
            case 2:
                System.out.println("Podaj nazwe samolotu, ktory chcesz usunac");
                String name = scann.nextLine();
                System.out.println("Podaj zasieg samolotu, ktory chcesz usunac");
                int range = scann.nextInt();
                System.out.println("Podaj liczbe miejsc samolotu, ktory chcesz usunac");
                int numberOfSeats = scann.nextInt();
                a.removeAirplane(name, range, numberOfSeats, true);
                secondChoice(a);
                break;
            case 3:
                a.showAirplane();
                secondChoice(a);
                break;
            case 0:
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void AirplaneChoice(AirportCompany a) {
        Scanner scan = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        String choice = scan.nextLine();
        switch (choice) {
            case "Boeing":
                System.out.println("Podaj kod nowego Boeinga");
                String name = scann.nextLine();
                Boeing b = new Boeing(name, 4000, 300, true);
                a.addAirplane(b);
                secondChoice(a);
                break;
            case "Tupolew":
                System.out.println("Podaj kod nowego Tupolewa");
                name = scann.nextLine();
                Tupolew t = new Tupolew(name, 2000, 500, true);
                a.addAirplane(t);
                secondChoice(a);
                break;
            case "Airbus":
                System.out.println("Podaj kod nowego Airbusa");
                name = scann.nextLine();
                Airbus ar = new Airbus(name, 5000, 250, true);
                a.addAirplane(ar);
                secondChoice(a);
                break;
            case "0":
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void thirdChoice(AirportCompany a) {
        System.out.println("1.Dodaj trase");
        System.out.println("2.Usun trase");
        System.out.println("3.Przegladaj trasy");
        System.out.println("4.Dodaj lotnisko");
        System.out.println("5.Usun lotnisko");
        System.out.println("6.Przegladaj lotniska");
        System.out.println("0.Powrot do menu glownego");
        Scanner scan = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Podaj nazwe lotniska oddlotu samolotu ");
                String departure = scann.nextLine();
                Airport l1 = new Airport(departure);
                System.out.println("Podaj nazwe lotniska przylotu samolotu ");
                String arrival = scann.nextLine();
                Airport l2 = new Airport(arrival);
                System.out.println("Podaj zasięg lotu ");
                int routeLenght = scann.nextInt();
                if (routeLenght <= 5000) {
                    Route r = new Route(l1, l2, routeLenght);
                    if (a.airportList.contains(l1) && a.airportList.contains(l2)) {
                        a.addRoute(r);
                    } else {
                        System.out.println("Najpierw dodaj lotniska");
                    }
                } else {
                    System.out.println("Nie posiadamy samolotu na dana trase");
                    break;
                }
                thirdChoice(a);
                break;
            case 2:
                System.out.println("Podaj numer trasy, ktora chcesz usunac");
                int numberOfRoutToRemove = scann.nextInt();
                a.removeRoute(numberOfRoutToRemove);
                thirdChoice(a);
                break;
            case 3:
                a.showRoute();
                thirdChoice(a);
                break;
            case 4:
                System.out.println("Podaj nazwe lotniska do dodania ");
                String airportName = scann.nextLine();
                Airport a1 = new Airport(airportName);
                a.addAirport(a1);
                thirdChoice(a);
                break;
            case 5:
                System.out.println("Podaj nazwe Lotniska do usuniecia");
                airportName = scann.nextLine();
                a.removeAirport(airportName);
                thirdChoice(a);
                break;
            case 6:
                a.showAirport();
                thirdChoice(a);
                break;
            case 0:
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void fourthChoice(AirportCompany a) {
        System.out.println("1.Dodaj Klienta");
        System.out.println("2.Usun Klienta");
        System.out.println("3.Przegladaj Klientow");
        System.out.println("0.Powrot do menu glownego");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Jakim jestes klientem:");
                System.out.println("1.Klient indywidualny");
                System.out.println("2.Firma posredniczaca");
                System.out.println("0.Powrot do menu glownego");
                ClientChoice(a);
                break;
            case 2:
                System.out.println("Jakim jestes klientem:");
                System.out.println("1.Klient indywidualny");
                System.out.println("2.Firma posredniczaca");
                System.out.println("0.Powrot do menu glownego");
                ClientRemove(a);
                fourthChoice(a);
                break;
            case 3:
                a.showClients();
                a.showIntermediaryCompany();
                fourthChoice(a);
                break;
            case 0:
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void ClientRemove(AirportCompany a) {
        Scanner scan = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Podaj PESEL klienta, ktorego chcesz usunac");
                String PESEl = scann.nextLine();
                a.removeClient(PESEl);
                break;
            case 2:
                System.out.println("Podaj KRS firmy, ktora chcesz usunac");
                String KRS = scann.nextLine();
                a.removeIntermediaryCompany(KRS);
                break;
            case 0:
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void ClientChoice(AirportCompany a) {
        Scanner scan = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Podaj swoje imie");
                String name = scann.nextLine();
                System.out.println("Podaj swoje nazwisko");
                String surname = scann.nextLine();
                System.out.println("Podaj swoj nr PESEL");
                String PESEL = scann.nextLine();
                do {
                    if (PESEL.length() == 11) {
                        IndividualClient c = new IndividualClient(name, surname, PESEL);
                        a.addClient(c);
                    } else {
                        System.out.println("Nie prawidlowy numer PESEL, wpisz ponownie");
                        PESEL = scann.nextLine();
                        if (PESEL.length() == 11) {
                            IndividualClient c = new IndividualClient(name, surname, PESEL);
                            a.addClient(c);
                        }
                    }
                }
                while (PESEL.length() != 11);
                fourthChoice(a);
                break;
            case 2:
                System.out.println("Podaj nazwe firmy");
                String companyName = scann.nextLine();
                System.out.println("Podaj numer KRS firmy");
                String KRS = scann.nextLine();
                do {
                    if (KRS.length() == 10) {
                        IntermediaryCompany ic = new IntermediaryCompany(companyName, KRS);
                        a.addIntermediaryCompany(ic);
                    } else {
                        System.out.println("Nie prawidlowy numer KRS, wpisz ponownie");
                        KRS = scann.nextLine();
                        if (KRS.length() == 10) {
                            IntermediaryCompany ic = new IntermediaryCompany(companyName, KRS);
                            a.addIntermediaryCompany(ic);
                        }
                    }
                }
                while (KRS.length() != 10);
                fourthChoice(a);
                break;
            case 0:
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void ClientChoiceToTicket(AirportCompany a) {
        Scanner scan = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Podaj swoj nr PESEL");
                String PESEL = scann.nextLine();
                do {
                    if (PESEL.length() == 11) {
                        Client c = a.ClientOfTicket(PESEL);
                        System.out.println("Wybierz lot");
                        a.showFlight();
                        choice = scan.nextInt();
                        Flight f = a.flightList.get(choice);
                        Ticket t = new Ticket(null, c, f);
                        a.addTicket(t);

                    } else {
                        System.out.println("Nie prawidlowy numer PESEL, wpisz ponownie");
                        PESEL = scann.nextLine();
                        if (PESEL.length() == 11) {
                            Client c = a.ClientOfTicket(PESEL);
                            System.out.println("Wybierz lot");
                            a.showFlight();
                            choice = scan.nextInt();
                            Flight f = a.flightList.get(choice);
                            Ticket t = new Ticket(null, c, f);
                            a.addTicket(t);
                        }
                    }
                }
                while (PESEL.length() != 11);
                fifthChoice(a);
                break;
            case 2:
                System.out.println("Podaj numer KRS firmy");
                String KRS = scann.nextLine();
                do {
                    if (KRS.length() == 10) {
                        IntermediaryCompany ic = a.intermediaryCompanyOfTicket(KRS);
                        System.out.println("Wybierz lot");
                        a.showFlight();
                        choice = scan.nextInt();
                        Flight f = a.flightList.get(choice);
                        Ticket t = new Ticket(ic, null, f);
                        a.addTicket(t);
                    } else {
                        System.out.println("Nie prawidlowy numer KRS, wpisz ponownie");
                        KRS = scann.nextLine();
                        if (KRS.length() == 10) {
                            IntermediaryCompany ic = a.intermediaryCompanyOfTicket(KRS);
                            System.out.println("Wybierz lot");
                            a.showFlight();
                            choice = scan.nextInt();
                            Flight f = a.flightList.get(choice);
                            Ticket t = new Ticket(ic, null, f);
                            a.addTicket(t);
                        }
                    }
                }
                while (KRS.length() != 10);
                fifthChoice(a);
                break;
            case 0:
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void fifthChoice(AirportCompany a) {
        System.out.println("1.Dodaj bilet");
        System.out.println("2.Usun bilet");
        System.out.println("3.Przegladaj bilety");
        System.out.println("0.Powrot do menu glownego");
        Scanner scan = new Scanner(System.in);
        Scanner scann = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Jakim jestes klientem:");
                System.out.println("1.Klient indywidualny");
                System.out.println("2.Firma posredniczaca");
                System.out.println("0.Powrot do menu glownego");
                ClientChoiceToTicket(a);
                break;
            case 2:
                System.out.println("Podaj numer biletu, ktory chcesz usunac");
                int numberOfTicketToRemove = scann.nextInt();
                a.removeTicket(numberOfTicketToRemove);
                fourthChoice(a);
                break;
            case 3:
                a.showTickets();
                fourthChoice(a);
                break;
            case 0:
                break;
            default:
                System.out.println("Nie ma takiej opcji, powrot do menu glownego.");
                break;
        }
    }

    static void saveRoutes(AirportCompany a) {
        try {
            File yourFile = new File("Routes.tmp");
            yourFile.createNewFile();
            FileOutputStream fos = new FileOutputStream("Routes.tmp", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a.routesList);
            oos.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void readRoutes(AirportCompany a) {

        try {
            FileInputStream fis = new FileInputStream("Routes.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            a.routesList = (ArrayList<Route>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void saveClients(AirportCompany a) {
        try {
            File yourFile = new File("Clients.tmp");
            yourFile.createNewFile();
            FileOutputStream fos = new FileOutputStream("Clients.tmp", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a.clientsList);
            oos.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void readClients(AirportCompany a) {

        try {
            FileInputStream fis = new FileInputStream("Clients.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            a.clientsList = (ArrayList<Client>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void saveIntermediaryCompanies(AirportCompany a) {
        try {
            File yourFile = new File("IntermediaryCompanies.tmp");
            yourFile.createNewFile();
            FileOutputStream fos = new FileOutputStream("IntermediaryCompanies.tmp", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a.intermediaryCompaniesList);
            oos.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void readIntermediaryCompanies(AirportCompany a) {

        try {
            FileInputStream fis = new FileInputStream("IntermediaryCompanies.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            a.intermediaryCompaniesList = (ArrayList<IntermediaryCompany>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void saveAirplanes(AirportCompany a) {
        try {
            File yourFile = new File("Airplanes.tmp");
            yourFile.createNewFile();
            FileOutputStream fos = new FileOutputStream("Airplanes.tmp", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a.airplaneList);
            oos.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void readAirplanes(AirportCompany a) {

        try {
            FileInputStream fis = new FileInputStream("Airplanes.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            a.airplaneList = (ArrayList<Airplane>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void saveAirports(AirportCompany a) {
        try {
            File yourFile = new File("Airports.tmp");
            yourFile.createNewFile();
            FileOutputStream fos = new FileOutputStream("Airports.tmp", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a.airportList);
            oos.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void readAirports(AirportCompany a) {

        try {
            FileInputStream fis = new FileInputStream("Airports.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            a.airportList = (ArrayList<Airport>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void saveFlights(AirportCompany a) {
        try {
            File yourFile = new File("Flights.tmp");
            yourFile.createNewFile();
            FileOutputStream fos = new FileOutputStream("Flights.tmp", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a.flightList);
            oos.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void readFlights(AirportCompany a) {

        try {
            FileInputStream fis = new FileInputStream("Flights.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            a.flightList = (ArrayList<Flight>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void saveTickets(AirportCompany a) {
        try {
            File yourFile = new File("Tickets.tmp");
            yourFile.createNewFile();
            FileOutputStream fos = new FileOutputStream("Tickets.tmp", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a.ticketsList);
            oos.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void readTickets(AirportCompany a) {
        try {
            FileInputStream fis = new FileInputStream("Tickets.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            a.ticketsList = (ArrayList<Ticket>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("***catch ERROR***");
            e.printStackTrace();
        }
    }

    static void save(AirportCompany a) {
        saveFlights(a);
        saveAirplanes(a);
        saveAirports(a);
        saveClients(a);
        saveRoutes(a);
        saveIntermediaryCompanies(a);
        saveTickets(a);
    }

    static void read(AirportCompany a) {
        readFlights(a);
        readAirplanes(a);
        readAirports(a);
        readClients(a);
        readRoutes(a);
        readIntermediaryCompanies(a);
        readTickets(a);
    }

    static void menu(AirportCompany a) {
        int choice;
        try {
            do {
                console(a);
                Scanner scan = new Scanner(System.in);
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        firstChoice(a);
                        break;
                    case 2:
                        secondChoice(a);
                        break;
                    case 3:
                        thirdChoice(a);
                        break;
                    case 4:
                        fourthChoice(a);
                        break;
                    case 5:
                        fifthChoice(a);
                        break;
                    case 0:
                        save(a);
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji.");
                        break;
                }

            } while (choice != 0);

        } catch (InputMismatchException e) {
            System.out.println("Podales liczbe w zlym formacie");
        }

    }


    public static void main(String[] args) {
        AirportCompany a = new AirportCompany();
        read(a);
        menu(a);
    }
}

