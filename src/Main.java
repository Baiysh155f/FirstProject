import classes.Client;
import service.serviceImpl.ClientServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(1L,"Baiysh Orozaliev", LocalDate.of(2000,1,20),"+996552930920", BigDecimal.valueOf(80000));
        Client client1 = new Client(2L,"Davran Joldoshbaev", LocalDate.of(2004,4,12),"+996552930920", BigDecimal.valueOf(3000));
        Client client2 = new Client(3L,"Eliza Ashyrbaeva", LocalDate.of(2003,3,5),"+996552930920", BigDecimal.valueOf(5900));

        Client client3 = new Client(4L,"Kurstan Erkinbaev", LocalDate.of(2023,7,13),"+996552930920", BigDecimal.valueOf(25000));

        List<Client> clients = new ArrayList<>(Arrays.asList(client,client1,client2));
        System.out.println(clients);
        ClientServiceImpl clientService = new ClientServiceImpl();

    }
}