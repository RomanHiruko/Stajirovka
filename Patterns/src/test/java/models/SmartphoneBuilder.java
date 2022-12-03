package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

public class SmartphoneBuilder {
    private Ram ram;
    private int rom = 256;
    private Company company;
    private String model = "Galaxy S20";

    public SmartphoneBuilder(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }

    public SmartphoneBuilder setRom(int rom) {
        this.rom = rom;
        return this;
    }

    public SmartphoneBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public Smartphone build() {
        Smartphone smartphone = new Smartphone();
        smartphone.setRam(this.ram);
        smartphone.setRom(this.rom);
        smartphone.setCompany(this.company);
        smartphone.setModel(this.model);
        return smartphone;
    }
}
