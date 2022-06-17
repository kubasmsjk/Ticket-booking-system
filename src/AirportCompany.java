import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;

public class AirportCompany implements Serializable {
    public ArrayList<Client> clientsList = new ArrayList<Client>();
    public ArrayList<IntermediaryCompany> intermediaryCompaniesList = new ArrayList<IntermediaryCompany>();
    public ArrayList<Airplane> airplaneList = new ArrayList<Airplane>();
    public ArrayList<Route> routesList = new ArrayList<Route>();
    public ArrayList<Airport> airportList = new ArrayList<Airport>();
    public ArrayList<Flight> flightList = new ArrayList<Flight>();
    public ArrayList<Ticket> ticketsList = new ArrayList<Ticket>();

    public void addClient(Client c) {
        clientsList.add(c);
    }

    public void showClients() {
        for (Client c : clientsList) {
            System.out.println(c);
        }
    }

    public void removeClient(String PESEL) {
        if (PESEL.length() != 11) {
            System.out.println("Nie prawidlowy numer PESEL");
        } else {
            for (int i = clientsList.size() - 1; i >= 0; i--) {
                if (clientsList.get(i).getPESEL().equals(PESEL)) {
                    clientsList.remove(i);
                    System.out.println("Pomyslne usuniecie");
                }
            }
        }
    }

    public Client ClientOfTicket(String PESEL) {
        Client c = null;
        for (int i = clientsList.size() - 1; i >= 0; i--) {
            if (clientsList.get(i).getPESEL().equals(PESEL)) {
                c = clientsList.get(i);
            }
        }
        return c;
    }

    public void addIntermediaryCompany(IntermediaryCompany ic) {
        intermediaryCompaniesList.add(ic);
    }

    public void showIntermediaryCompany() {
        for (IntermediaryCompany ic : intermediaryCompaniesList) {
            System.out.println(ic);
        }
    }

    public void removeIntermediaryCompany(String KRS) {
        if (KRS.length() != 10) {
            System.out.println("Nie prawidlowy numer KRS");
        } else {
            for (int i = intermediaryCompaniesList.size() - 1; i >= 0; i--) {
                if (intermediaryCompaniesList.get(i).getKRS().equals(KRS)) {
                    intermediaryCompaniesList.remove(i);
                    System.out.println("Pomyslne usuniecie");
                }
            }
        }
    }

    public IntermediaryCompany intermediaryCompanyOfTicket(String KRS) {
        IntermediaryCompany ic = null;
        for (int i = intermediaryCompaniesList.size() - 1; i >= 0; i--) {
            if (intermediaryCompaniesList.get(i).getKRS().equals(KRS)) {
                ic = intermediaryCompaniesList.get(i);
            }
        }
        return ic;
    }

    public void addAirplane(Airplane p) {
        airplaneList.add(p);
    }

    public void removeAirplane(String name, int range, int numberOfSeats, boolean status) {
        boolean vasible = true;
        for (int i = airplaneList.size() - 1; i >= 0; i--) {
            if (airplaneList.get(i).getName().equals(name) && airplaneList.get(i).getRange() == range && airplaneList.get(i).getNumberOfSeats() == numberOfSeats && airplaneList.get(i).isStatus() == true) {
                airplaneList.remove(i);
                System.out.println("Pomyslne usuniecie");
            }
        }
    }


    public void showAirplane() {
        for (Airplane p : airplaneList) {
            System.out.println(p);
        }
    }

    public void addRoute(Route r) {
        routesList.add(r);

    }

    public void showRoute() {
        for (Route r : routesList) {
            System.out.println(routesList.indexOf(r) + " " + r);
        }
    }

    public void removeRoute(int numberOfRoutToRemove) {
        routesList.remove(numberOfRoutToRemove);
        System.out.println("Pomyslne usuniecie");
    }

    public void addAirport(Airport a1) {
        airportList.add(a1);
    }


    public void showAirport() {
        System.out.println("Dostepne lotniska: ");
        for (Airport a1 : airportList) {
            System.out.println(a1);
        }
    }

    public void removeAirport(String airportName) {
        for (int i = airportList.size() - 1; i >= 0; i--) {
            if (airportList.get(i).getAirportName().equals(airportName)) {
                airportList.remove(i);
                checkRouteToRemove(airportName);
                System.out.println("Pomyslne usuniecie");
            }
        }
    }

    public void checkRouteToRemove(String airportName) {
        for (int i = routesList.size() - 1; i >= 0; i--) {
            if (routesList.get(i).getL1().getAirportName().equals(airportName) | routesList.get(i).getL2().getAirportName().equals(airportName)) {
                routesList.remove(i);
            }
        }
    }

    public Airplane comparisonRouteLenghtToRange(int routeLenght, ArrayList<Airplane> airplaneList) {
        Airplane p1 = null;
        Collections.sort(airplaneList, new Comparator<Airplane>() {
            @Override
            public int compare(Airplane o1, Airplane o2) {
                return Integer.compare(o1.getRange(), o2.getRange());
            }
        });
        for (Airplane p : airplaneList) {
            if (p.getRange() >= routeLenght && p.isStatus() == true) {
                p1 = p;
                p1.setStatus(false);
                break;
            }
        }
        if (p1 == null) {
            System.out.println("Nie posiadamy samolotu dla podanego zasiegu");
        }
        return p1;
    }

    public void addFlight(Flight f) {
        flightList.add(f);

    }

    public void showFlight() {
        for (Flight f : flightList) {
            System.out.println(flightList.indexOf(f) + " " + f);
        }
    }

    public void removeFlight(int numberOfFlightToRemove) {
        flightList.get(numberOfFlightToRemove).getP().setStatus(true);
        flightList.remove(numberOfFlightToRemove);
        System.out.println("Pomyslne usuniecie");
    }

    public void checkFlight() {
        for (int i = flightList.size() - 1; i >= 0; i--) {
            if (flightList.get(i).getDateOfArrival().isBefore(LocalDate.now()) && flightList.get(i).getHoursOfArrival().isBefore(LocalDateTime.now())) {
                flightList.get(i).getP().setStatus(true);
                removeFlight(i);
            }
        }

    }

    public void addTicket(Ticket t) {
        ticketsList.add(t);
    }

    public void showTickets() {
        for (Ticket t : ticketsList) {
            System.out.println(ticketsList.indexOf(t) + " " + t);
        }
    }

    public void removeTicket(int numberOfTicketToRemove) {
        ticketsList.remove(numberOfTicketToRemove);
        System.out.println("Pomyslne usuniecie");
    }

}



