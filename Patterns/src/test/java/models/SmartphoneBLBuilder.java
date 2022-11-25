package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

public class SmartphoneBLBuilder {
    private Ram ram;
    private int rom = 256;
    private Company company;
    private String model = "Galaxy S20";

    public SmartphoneBLBuilder(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }

    public SmartphoneBLBuilder setRom(int rom) {
        this.rom = rom;
        return this;
    }

    public SmartphoneBLBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public SmartphoneBL build() {
        SmartphoneBL smartphone = new SmartphoneBL();
        smartphone.setRam(this.ram);
        smartphone.setRom(this.rom);
        smartphone.setCompany(this.company);
        smartphone.setModel(this.model);
        return smartphone;
    }
}
