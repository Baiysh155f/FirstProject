package classes;

import enums.Gender;

import java.math.BigDecimal;

public class Driver {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private    String phoneNumber;
    private License license;
    private BigDecimal money;


    public Driver(Long id, String name, String surname, Gender gender, String phoneNumber, License license, BigDecimal money) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.license = license;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "\nDriver :" +
                "\nid :" + id +
                "\nname :" + name + '\'' +
                "\nsurname :" + surname + '\'' +
                "\ngender :" + gender +
                "\nphoneNumber :" + phoneNumber + '\'' +
                "\nlicense :" + license +
                "\nmoney :" + money ;
    }
}
