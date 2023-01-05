package service.serviceImpl;

import classes.Taxi;
import dao.Database;
import service.DriverService;

import java.sql.Driver;
import java.util.*;

public class DriverImpl implements DriverService {
    private Database database;

    public DriverImpl(Database database) {
        this.database = database;
    }

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
        return null;// database.getDrivers().stream().filter(x -> x.getDrivers.getId().equals(id)).toList();

    }

    @Override
    public List<Driver> findByName(String name) {
        return null;//database.getDrivers().stream().filter(x->x.getDrivers.getName().equals(name)).toList();
    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
        return null;
    }

    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        return null;
    }

    @Override
    public List<Taxi> getDriverByTaxiModel(String model){
        return database.getTaxis().stream().filter(x -> x.getModel().equals(model)).toList();
}

    @Override
    public void update(String driverName) {


    }
}