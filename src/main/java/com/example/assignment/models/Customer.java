package com.example.assignment.models;

public class Customer {

    private String country;
    private String postalCode;
    private String phone;
    private String email;
    private int customerId;
    private String firstName;
    private String lastName;

    public Customer(int customerId, String firstName, String lastName, String country, String postalCode, String phone, String email) {
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Getters
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getCountry() {
        return country;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "models.Customer{" + "customerId='" + customerId + '\'' + ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + ", country='" + country + '\'' + ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' + ", email='" + email + '\'' + '}';
    }


}
