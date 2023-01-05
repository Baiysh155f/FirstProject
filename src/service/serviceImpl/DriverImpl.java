package service.serviceImpl;

import dao.Database;
import service.DriverService;

import java.sql.Driver;
import java.util.LinkedList;
import java.util.List;

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
        drivers.forEach(database.getDrivers()::remove);
        database.drivers.addAll(drivers);
        return driverList;
    }

    @Override
    public Driver findById(Long id) {
        return null;
    }

    @Override
    public List<Driver> findByName(String name) {
        return null;
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
    public List<Driver> getDriverByTaxiModel(String model) {
        return null;
    }

    @Override
    public void update(String driverName) {

    }
}
