package service.serviceImpl;

import classes.Taxi;
import dao.Database;
import classes.Driver;
import service.DriverService;

import java.math.BigDecimal;
import java.util.*;


public class DriverImpl implements DriverService {
    private Database database = new Database();

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
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
        return  (Driver) database.getDrivers().stream().filter(x -> x.getId().equals(id)).toList();

    }

    @Override
    public List<Driver> findByName(String name) {
        return  database.getDrivers().stream().toList().stream().filter(x -> x.getName().equals(name)).toList();

    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
            for (Taxi taxi : database.getTaxis()) {
                if (taxi.getModel().equals(taxiName)) {
                    for (Driver driver : database.getDrivers()) {
                        if (driver.getId().equals(driverId)) {
                            driver.setTaxi(taxi);
                        }
                    }
                }
        }
        return  " Successfully!";
    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        Driver driver1 = null;
        Taxi taxi1 = null;
        for (Driver driver : database.getDrivers()) {
            if(Objects.equals(driver.getId(), driverId)){
                driver1 = driver;
            }
        }
        for (Driver driver : database.getDrivers()) {
            if(Objects.equals(taxiId, driver.getId())){
                driver1 = driver;
            }
        }
        assert driver1 != null;
        driver1.setTaxi(taxi1);
        return" Successful !!!";
    }

    @Override
    public List<Driver> getDriverByTaxiModel(String model) {
        List<Driver>result = new ArrayList<>();
        result = database.getDrivers().stream().filter(x -> x.getTaxi().getModel().equals(model)).toList();
        return result;
    }


    @Override
    public void update(String driverName) {
        Scanner scanner = new Scanner(System.in);
        for (Driver driver : database.getDrivers()) {
            if (driver.getName().equals(driverName)) {
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
