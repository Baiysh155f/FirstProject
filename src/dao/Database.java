package dao;

import classes.Client;
import classes.Driver;
import classes.License;
import classes.Taxi;

import java.util.Set;

public class Database {
    private Set<Client> clients;
    private Set<Driver> drivers;
    private Set<Taxi> taxis;

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(Set<Taxi> taxis) {
        this.taxis = taxis;
    }

}
