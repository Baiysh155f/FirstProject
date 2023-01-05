import classes.Client;
import service.serviceImpl.ClientServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(1L, "Baiysh Orozaliev", LocalDate.of(2000, 1, 20), "+996552930920", BigDecimal.valueOf(80000L));
        Client client1 = new Client(2L, "Davran Joldoshbaev", LocalDate.of(2004, 4, 12), "+996552930920", BigDecimal.valueOf(3000L));
        Client client2 = new Client(3L, "Eliza Ashyrbaeva", LocalDate.of(2003, 3, 5), "+996552930920", BigDecimal.valueOf(5900L));

        Client client3 = new Client(4L, "Kurstan Erkinbaev", LocalDate.of(2023, 7, 13), "+996552930920", BigDecimal.valueOf(25000L));

        Set<Client> clients = new HashSet<>(Arrays.asList(client, client1, client2));
        System.out.println(clients);
//        ClientServiceImpl clientService = new ClientServiceImpl();
//        System.out.println("______________________");
//        System.out.println(clientService.addClient(client3));
    }
}