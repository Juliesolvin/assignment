package com.example.assignment.controllers;

import com.example.assignment.models.Customer;
import com.example.assignment.data_access.CustomerRepository;
import com.example.assignment.models.CustomerCountry;
import com.example.assignment.models.CustomerSpender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;


@RestController
public class CustomerController {

    // Make  a method for every method in repository

    // Configure some endpoints to manage crud
    private final CustomerRepository customerRepository;


    public CustomerController(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    /*
     This first one just returns all the customers in the database
     it will return a CustomerShort object.
     Requierement 1)
    */
    @RequestMapping(value="/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers() throws SQLException {
        System.out.println("API/CUSTOMERS");
        return customerRepository.getAllCustomers();
    }

       /*
     This returns a specific customer, based on a given Id.
     We use a path variable here to extract the Id.
     From Nic`s Git
     Requirement 2)
    */



    @RequestMapping(value = "/api/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomerByPathId(@PathVariable int id){

        return customerRepository.getCustomerById(id);
    }

       /*
     Requirement 3)
     Read a specific customer by name
    */

    @GetMapping("api/customers")
    public Customer getCustomerByName(@RequestParam(value = "name", required = false) String name1,String name2){
            return customerRepository.getCustomerByName(name1, name2);
    }



    /*
    Requierement 4) Return a page of customers from the database
          * This should take a limit and offset as parameters,
            * and make us the SQL keywords to get a subset data
          * Okei: So offset: Is where in the database we start
          * limit: How many
            */

    // Still a static problem
    @GetMapping("/api/customer/all/offset/{limit}/{offset}")
    public ArrayList<Customer> getCustomerSubList(@PathVariable int limit, @PathVariable int offset) {
        return customerRepository.getCustomerSubList(limit, offset);
    }

           /*

     Requirement 5)

     This adds a new customer.
     It takes the new customer from the body of the request.
    */

    @RequestMapping(value = "api/customers", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
         return customerRepository.addCustomer(customer);
    }


    /*
    Requirement 6) Update excisting customer
     */

    @PatchMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer){
        return customerRepository.updateCustomer(id, updatedCustomer);
    }


           /*

     Requirement 7)
     Return the number of customers in each country.
    */

    @GetMapping("/customers/country-to-customer")
    public ArrayList<CustomerCountry> getNumberOfCustomersToCountry(){
        return customerRepository.getCountriesByCount();
    }


           /*

     Requirement 8)
     Customers who are the highest spenders (Total in invoicetable is the largest), ordered descending,
    */

    @GetMapping("/customers/highest-spenders")
    public ArrayList<CustomerSpender> getHighestSpenders(){
        return customerRepository.getCustomersSpend();
    }

           /*

     Requirement 9)
              /* Requierement 9: For a given customer, their most
         * popular genre (in the case of tie, display both)
         * Most popular in this context means the genre that
         * corresponds to the most tracks from the invoices assoiciated
         * to that customer */










}
