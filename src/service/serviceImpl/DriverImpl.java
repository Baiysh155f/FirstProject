package service.serviceImpl;

import classes.Taxi;
import dao.Database;
import service.DriverService;

import java.sql.Driver;
import java.util.*;


public class DriverImpl implements DriverService {
    private Database database = new Database();
    private List<Driver> driverList = new ArrayList<>();

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    @Override
    public Driver add(Driver driver) {
        database.getDrivers().add(driver);
        return driver;
    }

    @Override
    public List<Driver> add(List<Driver> drivers) {
        database.getDrivers().addAll(drivers);
        return drivers;
    }

    @Override
    public Driver findById(Long id) {
        Driver drivers1 = database.getDrivers().stream().filter(driver -> driver.getId().equals(id)).toList();
        return drivers1;
    }

    @Override
    public List<Driver> findByName(String name) {
        List<Driver> driverList = database.getDrivers().stream().toList().stream().filter(x -> x.getName().equals(name)).toList();
        return driverList;
    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
        Taxi taxi = null;
        for (Taxi taxi1 : database.getTaxis()) {
            if (Objects.equals(taxi1.getModel(), taxiName)) {
                taxi = taxi1;
            }
        }
        for (Driver driver : database.getDrivers()) {
            if (Objects.equals(driver.getId(), driverId)) {
                driver.setTaxi(taxi);
            }
        }
        return "Successfully !!! ";
    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        Driver driver1 = null;
        for (Driver driver : database.getDrivers()) {
            if (driver.getId().equals(driverId)) {
                driver1 = driver;
            }
        }
        Taxi taxi1 = null;
        for (Taxi taxi : database.getTaxis()) {
            if (Objects.equals(taxi.getId(), taxiId)) {
                taxi1 = taxi;
            }
        }
        driver1.setTaxi(taxi1);
        return" Successful !!!";
    }

    @Override
    public List<Taxi> getDriverByTaxiModel(String model) {
        return database.getDrivers().stream().filter(driver -> driver.getTaxi().getModel().equals(model)).toList();
    }


    @Override
    public void update(String driverName) {
        Scanner scanner = new Scanner(System.in);
        for (Driver driver : database.getDrivers()) {
            if (driverList.getName().equals(driverName)) {
                System.out.println(" ID : ");
                driver.setId(scanner.nextLong());
                System.out.println("SurName : ");
                driver.setSurname(scanner.next());
                System.out.println("Phone number : ");
                driver.setPhoneNumber(scanner.next());
                System.out.println("Money : ");
                driver.setMoney(scanner.nextBigDecimal());
            }
        }
    }
}
    }
}