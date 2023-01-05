package service.serviceImpl;

import classes.Taxi;
import dao.Database;
import service.DriverService;

import java.sql.Driver;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DriverImpl implements DriverService {
    List<Driver>driverList = new LinkedList<>();
    @Override
    public Driver add(Driver driver) {
        driverList.add(driver);
        return driver;
    }

    @Override
    public List<Driver> add(List<Driver> drivers) {
        driverList.addAll(drivers);
        Database database = new Database();
        drivers.forEach(database.drivers::remove);
        return driverList;
    }

    @Override
    public Driver findById(Long id) {
        for (Driver driver : this.driverList) {
            if (Objects.equals(driver.getId(), id)) {
                return driver;
            } else {
                System.out.println("Wrong id!!");
            }

        }

        return null;
    }

    @Override
    public List<Driver> findByName(String name) {
        return driverList.stream().filter(x -> x.getName().equals(name)).toList();
    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
        Database database = new Database();
        Driver driver1 = null;
        Taxi taxi = null;
        for (classes.Driver driver : database.drivers) {
            if(Objects.equals(driver.getId(), driverId)){
                driver1 = (Driver) driver;
            }
        }
        for (Taxi taxi : database.taxis) {
            if(Objects.equals(taxiName, taxi.getId())){
                taxi = taxi;
            }
        }
        assert driver != null;
        activeDriver.setTaxis(activeTaxi);
        return "successfully !!!";

    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        classes.Driver activeDriver = null;
        Taxi activeTaxi = null;

        Database database = new Database();
        for (Taxi taxi1 : database.taxis) {
            if (Objects.equals(taxi1.getId(), taxiId)){
                activeTaxi = taxi1;
            }
        }
        for (classes.Driver driver1 : database.drivers) {
            if (Objects.equals(driver1.getId(), driverId)) {
                activeDriver = driver1;
            }
        }
        assert activeDriver != null;
        activeDriver.setTaxis(activeTaxi);

        return " successful!!";

    }

    @Override
    public List<Driver> getDriverByTaxiModel(String model) {
        return driverList.stream().filter(s -> s.getTaxis().getModel().equals(model)).toList();
    }

    @Override
    public void update(String driverName) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        for (classes.Driver driver : database.drivers) {
            if (driver.getName().equals(driverName)){
                System.out.println("Surname: ");
                driver.setSurname(scanner.next());
                System.out.println("Phone Number: ");
                driver.setPhoneNumber(scanner.nextLine());
                System.out.println("Money: ");
                driver.setMoney(scanner.nextBigDecimal());
    }
}
