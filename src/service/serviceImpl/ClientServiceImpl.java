package service.serviceImpl;

import classes.Client;
import classes.Taxi;
import dao.Database;
import service.ClientService;

import java.util.*;

public class ClientServiceImpl implements ClientService {
    private Database database;
    @Override
    public String addClient(Client client) {
        Set<Client> clients2 = new HashSet<>();
        clients2.add(client);
        database.setClients(clients2);
        return "successfully added client";
    }

    @Override
    public String addClient(List<Client> clients) {
        Set<Client> clients1 = new HashSet<>(clients);
        database.setClients(clients1);
        return "successfully added clients";
    }

    @Override
    public List<Client> getClientByName(String name) {
        return null;
    }

    @Override
    public Client removeClientById(Long id) {
        return null;
    }

    @Override
    public Taxi orderTaxi(Long clientId, String taxiType) {
        return null;
    }

    @Override
    public Map<Integer, Client> getClientAge() {
        return null;
    }

    @Override
    public void universalSorting(String word) {
        while (true) {
            System.out.println("""
                    press 1 to sorted A-Z
                    press 2 to sorted Z-A
                    press 3 to sorted date of birth ascending
                    press 4 to sorted date of birth descending
                    press 5 to sorted money ascending
                    press 6 to sorted money descending""");
            int str = new Scanner(System.in).nextInt();
            switch (str) {
                case 1 -> database.getClients().stream().sorted(Comparator.comparing(Client::getFullName)).forEach(System.out::println);
                case 2 -> database.getClients().stream().sorted(Comparator.comparing(Client::getFullName).reversed()).forEach(System.out::println);
                case 3 -> database.getClients().stream().sorted(Comparator.comparing(Client::getDateOfBirth)).forEach(System.out::println);
                case 4 -> database.getClients().stream().sorted(Comparator.comparing(Client::getDateOfBirth).reversed()).forEach(System.out::println);
                case 5 -> database.getClients().stream().sorted((Comparator.comparing(Client::getMoney))).forEach(System.out::println);
                case 6 -> database.getClients().stream().sorted(Comparator.comparing(Client::getMoney).reversed()).forEach(System.out::println);
                default -> System.out.println("error");
            }
            if (str == 9) {
                break;

            }
        }
    }
}
