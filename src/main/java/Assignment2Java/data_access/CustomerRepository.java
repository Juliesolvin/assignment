package Assignment2Java.data_access;

import Assignment2Java.models.Customer;
import Assignment2Java.models.CustomerCountry;
import Assignment2Java.models.CustomerSpender;

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

        // Works in progress:
        // public ArrayList<CustomerGenre> getPopular();
    }


