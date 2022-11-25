package models;

import java.io.Serializable;

public class SmartphoneJB implements Serializable {
    private int ram;
    private String company;
    private String sort;

    public SmartphoneJB() {

    }

    public SmartphoneJB(int ram, String company, String sort) {
        this.ram = ram;
        this.company = company;
        this.sort = sort;
    }

    public int getRam() {
        return ram;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
