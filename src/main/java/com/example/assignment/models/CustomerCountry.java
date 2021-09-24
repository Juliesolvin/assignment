package com.example.assignment.models;

public class CustomerCountry {
    String name;
    int num;

    public CustomerCountry(String name, int num) {
        this.name = name;
        this.num = num;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getNum() {
        return num;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNumberOfCustomers(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CustomerCountry{" +  "name='" + name + '\'' + ", numberOfCustomers=" + num + '}';
    }

}
