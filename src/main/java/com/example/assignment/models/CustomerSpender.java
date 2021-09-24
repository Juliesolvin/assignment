package com.example.assignment.models;

public class CustomerSpender {
    int id;
    double totalMoneySpent;

    public CustomerSpender(int id, double totalMoneySpent) {
        this.id = id;
        this.totalMoneySpent = totalMoneySpent;
    }

    @Override
    public String toString() {
        return "CustomerSpender{" +
                "id=" + id +
                ", total Money spent= " + totalMoneySpent +
                '}';
    }
}
