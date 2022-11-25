package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;
import models.valueobjects.Sort;

import java.io.Serializable;

public class SmartphoneVO implements Serializable {
    private Ram ram;
    private Company company;
    private Sort sort;

    private SmartphoneVO(){}

    public SmartphoneVO(Ram ram, Company company, Sort sort){
        this.ram = ram;
        this.company = company;
        this.sort = sort;
    }

    public Ram getRam() {
        return this.ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Sort getSort() {
        return this.sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
