package com.milkyweb.model;

public class Carrier {
    private String name;
    private String phone;
    private String fax;
    private String equipment;
    private String agreedAmount;
    private String loadStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getAgreedAmount() {
        return agreedAmount;
    }

    public void setAgreedAmount(String agreedAmount) {
        this.agreedAmount = agreedAmount;
    }

    public String getLoadStatus() {
        return loadStatus;
    }

    public void setLoadStatus(String loadStatus) {
        this.loadStatus = loadStatus;
    }
}
