package service.serviceImpl;

import classes.Taxi;
import dao.Database;
import enums.TaxiType;
import service.TaxiService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaxiServiceImpl implements TaxiService {
    private Database database=new Database();
    List<Taxi> taxises = new ArrayList<>();

    @Override
    public StringBuilder add(Taxi taxi) {
        Set<Taxi> list = new HashSet<>(database.getTaxis());
        if (taxi.getYear().isAfter(LocalDate.of(2010, 1, 1))) {
            taxises.add(taxi);
        }
        database.setTaxis(list);
        return new StringBuilder("Successfully added");
    }

    @Override
    public StringBuilder add(List<Taxi> taxis) {
        this.taxises.addAll(taxis);
        database.getTaxis().add((Taxi) taxis);
        return new StringBuilder("Successfully added");
    }

    @Override
    public List<Taxi> findByInitialLetter(String model) {
        return database.getTaxis().stream().filter(taxi -> taxi.getModel().startsWith(model)).toList();
    }

    @Override
    public Map<TaxiType, List<Taxi>> grouping() {

        return taxises.stream().collect(Collectors.groupingBy(Taxi::getTaxiType));
    }

    @Override
    public List<Taxi> filterByTaxiType(String taxiType) {
        return database.getTaxis().stream().filter(taxi -> taxi.getTaxiType().name().equals(taxiType)).toList();
    }

    @Override
    public void update(Long id) {
        for (Taxi taxi : database.getTaxis()) {
            if (taxi.getId() == id.longValue()) {
                while (true) {
                    System.out.println("""
                            1: Change id
                            2: Сhange number
                            3: Change color
                            4: Change TaxiType
                            """);
                    int num = new Scanner(System.in).nextInt();
                    switch (num) {
                        case 1 -> taxi.setId(new Scanner(System.in).nextLong());
                        case 2 -> taxi.setNumber(new Scanner(System.in).nextLine());
                        case 3 -> taxi.setColour(new Scanner(System.in).nextLine());
                        case 4 -> {
                            String taxiType = new Scanner(System.in).nextLine();
                            taxi.setTaxiType(TaxiType.valueOf(taxiType));
                        }

                    }

                }
            }

        }
    }
}
