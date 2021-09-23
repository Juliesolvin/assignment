package Assignment2Java.data_access;

import Assignment2Java.models.Customer;
import Assignment2Java.models.CustomerCountry;
import Assignment2Java.models.CustomerSpender;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

     /*
     This class serves as the encapsulation of all database interactions,
     it removes the implementation from the controllers to models - as they should only be responsible
     for handling user interactions and deciding what to do with it.

     This is where we use queries ect.
    */
    @Repository

    // CLASS
    public class CustomerRepositoryImpl implements CustomerRepository {


         // ATTRIBUTES

         // HER ER URL`EN
         private String URL = ConnectionHelper.CONNECTION_URL;
         private Connection conn = null;
         ArrayList<Customer> customers = new ArrayList<>();

         /*  Methods:
          We need methods to serve the needs of the controller requests.
          Just mirror what your endpoints want!
          (See the Assignment for endpoints)

          */


         // Returns a list of Customers [See Customer class]

         // METHOD THAT RETURNS CUSTOMERS
         /* Requirement 1: Display all customers  */

         public ArrayList<Customer> getAllCustomers() throws SQLException {

             try {
                 // 1) Open Connection to DB
                 // Inspo from Nics notes - Connection_URL and ConnectionHelper
                 conn = DriverManager.getConnection(ConnectionHelper.CONNECTION_URL);
                 System.out.println("Connection to SQLite has been established");

                 // 2) (From Step 3 in powerpoint): Prepare statement;
                 // Make SQL query
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email" +
                         "FROM customer");

                 // 3) Execute Query
                 // ResultSet is its own class, look it up
                 ResultSet resultSet = preparedStatement.executeQuery();

                 // Puts all the customers in a resultSet
                 while (resultSet.next()) {
                     customers.add(
                             new Customer(
                                     resultSet.getInt("CustomerId"),
                                     resultSet.getString("FirstName"),
                                     resultSet.getString("LastName"),
                                     resultSet.getString("Country"),
                                     resultSet.getString("PostalCode"),
                                     resultSet.getString("Phone"),
                                     resultSet.getString("Email")
                             ));
                 }
                 // Nic has a logger class where he loggs everything -
                 // Not necessary for assignment
             } catch (Exception exception) {
                 System.out.println("Her skal det være en exception");
             } finally {
                 try {
                     conn.close();
                 } catch (Exception exception) {
                     System.out.println("Another exception - Nic uses logger-class");
                 }
             }
             return customers;
         }


         /* Requirement 2: Read a specific customer from the
          * database by Id, and display everything listet  */
         public Customer getCustomerById(int custId) {
             Customer customer = null;
             try {
                 // again, connect to DB
                 conn = DriverManager.getConnection(URL);

                 // Make SQL query
                 // Not sure about this one right underneath here.
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email" +
                         "FROM customer as c " + "WHERE c.CustomerId = ?");

                 // Why has the "1" a red mark?
                 int i = 1;
                 preparedStatement.setInt(i, custId);

                 // Execute Query
                 ResultSet resultSet = preparedStatement.executeQuery();

                 while (resultSet.next()) {
                     new Customer(
                             resultSet.getInt("CustomerId"),
                             resultSet.getString("FirstName"),
                             resultSet.getString("LastName"),
                             resultSet.getString("Country"),
                             resultSet.getString("PostalCode"),
                             resultSet.getString("Phone"),
                             resultSet.getString("Email")
                     );
                 }
             } catch (Exception exception) {
                 System.out.println("New exception");
             } finally {
                 try {
                     conn.close();
                 } catch (Exception exception) {
                     System.out.println("Some type of exception");
                 }
             }

             return customer;

         }

         /* Requierement 3) Read a specific customer by name */

         public Customer getCustomerByName(String name1, String name2) {

             // Example: SELECT * FROM department WHERE NAME LIKE 'H%';
             Customer customer = null;

             try {
                 // again, connect to DB
                 conn = DriverManager.getConnection(URL);

                 // Make query
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email" +
                         "FROM customer as c " + "WHERE c.firstname LIKE name1 AND c.lastname LIKE name2");



                 int i = 1;
                 int ii = 2;
                 preparedStatement.setString(i, name1);
                 preparedStatement.setString(ii, name2);

                 // Execute Query
                 ResultSet resultSet = preparedStatement.executeQuery();

                 while (resultSet.next()) {
                     new Customer(
                             resultSet.getInt("CustomerId"),
                             resultSet.getString("FirstName"),
                             resultSet.getString("LastName"),
                             resultSet.getString("Country"),
                             resultSet.getString("PostalCode"),
                             resultSet.getString("Phone"),
                             resultSet.getString("Email")
                     );
                 }
             } catch (Exception exception) {
                 System.out.println("New exception");
             } finally {
                 try {
                     conn.close();
                 } catch (Exception exception) {
                     System.out.println("Some type of exception");
                 }
             }

             return customer;

         }

         /* Requierement 4) Return a page of customers from the database
          * This should take a limit and offset as parameters,
          * and make us the SQL keywords to get a subset data
          * Okei: So offset: Is where in the database we start
          * limit: How many*/

         public ArrayList<Customer> getCustomerSubList(Integer limit, Integer offset)  {

             ArrayList<Customer> customersubpage = new ArrayList<>();
             PreparedStatement preparedStatement;

             try {
                 // again, connect to DB
                 conn = DriverManager.getConnection(URL);

                 if (limit == 0) {
                     // SubList starts at 0, so we just print all customers
                     // should have done something better here, but we just copy from getAllCustomers

                     // Make SQL query
                     preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email" +
                             "FROM customer");

                 } else {
                     preparedStatement = conn.prepareStatement("SELECT CustomerId,FirstName,LastName,Country,PostalCode,Phone,Email " +
                             "FROM customer " +
                             "LIMIT ? " +
                             "OFFSET ?");

                     int i = 1;
                     int ii = 2;
                     preparedStatement.setInt(i, limit);
                     preparedStatement.setInt(ii, offset);
                 }

                 // Fortsatt inne i try`en
                 // Execute Query

                 ResultSet resultSet = preparedStatement.executeQuery();

                 while (resultSet.next()) {
                     customers.add(
                             new Customer(
                                     resultSet.getInt("CustomerId"),
                                     resultSet.getString("FirstName"),
                                     resultSet.getString("LastName"),
                                     resultSet.getString("Country"),
                                     resultSet.getString("PostalCode"),
                                     resultSet.getString("Phone"),
                                     resultSet.getString("Email")
                             ));
                 }



             } catch (Exception exception) {
                 System.out.println("Exception string");
             }

             // Returners "subdatabase"
             return customersubpage;


         }

             // Requirement 5: Adds customer to the database
         public Boolean addCustomer(Customer customer){
             Boolean success = false;

             try {
                 //Again, as always, connect to DB
                 conn = DriverManager.getConnection(URL);

                 // Make SQL query
                 // Does not need to use every kolonne
                 // What kolonne says in the assignment

                 // OBS: Do not insert CustomerId, it generates(?) itself
                 PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Customer(FirstName, LastName, Country, PostalCode, Phone, Email) VALUES(????)");
                 preparedStatement.setString(1, customer.getFirstName());
                 preparedStatement.setString(2, customer.getLastName());
                 preparedStatement.setString(3, customer.getCountry());
                 preparedStatement.setString(4, customer.getPostalCode());
                 preparedStatement.setString(5, customer.getPhone());
                 preparedStatement.setString(6, customer.getEmail());

                 // Execute Query

                 int result = preparedStatement.executeUpdate();

                 if (result != 0) {
                     success = true;
                 }

             } catch (Exception exception) {
                 System.out.println("Some type of message");
             }
             finally {
                 try{
                     conn.close();
                 }
                 catch (Exception exception){
                     System.out.println("Some type of message");
                 }
             }
             return success;
         }


    /*
    Requirement 6) Update excisting customer
     */
        public Customer updateCustomer(int id, Customer customer) {

        try {
            // Connect to DB
            conn = DriverManager.getConnection(URL);
            System.out.println("Du har koblet til databasen");

            // Makes SQL query
            // Set alle, where - by the Customers id
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Customer SET FirstName = ?, LastName = ?, Country = ?, PostalCode = ?, Phone = ?, Email = ?, WHERE CustomerId = ?");

            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getCountry());
            preparedStatement.setString(4, customer.getPostalCode());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setInt(7, customer.getCustomerId());

            preparedStatement.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Some type of exception");
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println("Exception av noe slag");
            }
        }
        return getCustomerById(id);
    }



         /* Requieremnt 7: Return the number of customers
         * in each country, ordered descending high to low. That
         * is USA: 13, .... */


         public ArrayList<CustomerCountry> getCountriesByCount() {
             ArrayList<CustomerCountry> countries = new ArrayList<>();

             try {
                 // Connect to DB
                 conn = DriverManager.getConnection(URL);
                 System.out.println("Du har koblet til databasen");

                 // Makes SQL query
                 // Set alle, where - by the Customers id
                 // Not sure of this underneath

                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT Country, COUNT(CustomerId) number FROM Customer GROUP BY Country ORDER BY number DESC");
                 ResultSet resultSet = preparedStatement.executeQuery();

                 while (resultSet.next()) {
                     countries.add(new CustomerCountry(resultSet.getString("Country"),  resultSet.getInt("Number")));
                 }

             }
             catch (Exception exception){
                 System.out.println("Exceptiontext");
             }

             finally {
                 try {
                     conn.close();
                 } catch (Exception exception) {
                     System.out.println("Exception av noe slag");
                 }
             }

             return countries;

         }


         /* Requierement 8: Customer who are the highest spenders
         * Total in invoice table, ordered descending*/


         public ArrayList<CustomerSpender> getCustomersSpend() {
             ArrayList<CustomerSpender> costumerSpend = new ArrayList<>();
             try {
                 // Connect to DB
                 conn = DriverManager.getConnection(URL);
                 System.out.println("Du har koblet til databasen");

                 // Makes SQL query
                 // Set alle, where - by the Customers id

                 // Find another solution? Does this work?
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT ROUND(SUM(i.Total), 2) as Moneyspent, CustomerId " +
                         "FROM Invoice i NATURAL JOIN Customer custom " +
                         "GROUP BY CustomerId " +
                         "ORDER BY Moneyspent DESC") ;

                 ResultSet resultSet = preparedStatement.executeQuery();
                 while (resultSet.next()) {
                     //GetDouble and not getInt at totalMoneySpent in CustomerSpender is a double
                     costumerSpend.add(new CustomerSpender(resultSet.getInt("CustomerId"),  resultSet.getDouble("Moneyspent")));
                 }
             }
             catch (Exception exception){
                 System.out.println("Exceptiontext");
             }
             finally {
                 try {
                     conn.close();
                 } catch (Exception exception) {
                     System.out.println("Exception av noe slag");
                 }
             }
             return costumerSpend;
         }

         /* Requierement 9: For a given customer, their most
         * popular genre (in the case of tie, display both)
         * Most popular in this context means the genre that
         * corresponds to the most tracks from the invoices assoiciated
         * to that customer */

/*   WORK IN PROGRESS:
         @Override
         public ArrayList<CustomerGenre> getPopular() {
             ArrayList<CustomerGenre> popular = new ArrayList<>();
             try {
                 // Connect to DB
                 conn = DriverManager.getConnection(URL);
                 System.out.println("Du har koblet til databasen");

                 // Makes SQL query

                 // Find another solution?
                 PreparedStatement preparedStatement = conn.prepareStatement("Struggled with this one") ;

                 ResultSet resultSet = preparedStatement.executeQuery();
                 while (resultSet.next()) {
                     //GetDouble and not getInt at totalMoneySpent in CustomerSpender is a double
                      popular.add(new CustomerSpender(resultSet.getInt(1),  resultSet.getDouble(1.0)));
                 }
             }
             catch (Exception exception){
                 System.out.println("Exceptiontext");
             }
             finally {
                 try {
                     conn.close();
                 } catch (Exception exception) {
                     System.out.println("Exception av noe slag");
                 }
             }
             return popular;
         }

    */



         /**
          * Thymeleaf requirements:
          * (a) Finds 5 random tracks, 5 random songs, and 5 random genres.
          * This homepage contains a search bar which is used to search for tracks.
          * The search bare should not be empty, meaning you cant have an empty search
          * criterion.
          */

         /**
          * Thymeleaf requirements:
          * (b) The search results page will show the query user has made.
          * Underneath this, the results will be shown for the search.
          * The search results should show a row where the track name, artist, album
          * and genre are shown
          * The search should also be case insensitive.
          */
     }
