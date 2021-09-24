package com.example.assignment.data_access;

import com.example.assignment.models.Customer;
import com.example.assignment.models.CustomerCountry;
import com.example.assignment.models.CustomerGenre;
import com.example.assignment.models.CustomerSpender;

import java.sql.SQLException;
import java.util.ArrayList;


    public interface CustomerRepository {
        public ArrayList<Customer> getAllCustomers() throws SQLException;
        public Customer getCustomerById(int custId);
        public Customer getCustomerByName(String firstname, String lastname);
        public ArrayList<Customer> getCustomerSubList(Integer limit, Integer offset);
        public ArrayList<CustomerCountry> getCountriesByCount();
        public Boolean addCustomer(Customer customer);
        public Customer updateCustomer(int id, Customer customer);
        public ArrayList<CustomerSpender> getCustomersSpend();
        public ArrayList<CustomerGenre> getPopular(int Customerid);
    }


