package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

import java.io.Serializable;

public class Smartphone implements Serializable {
    private Ram ram;
    private int rom;
    private Company company;
    private String model;

    public Smartphone() {
    }

    public Smartphone(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
