package Assignment2Java.models;

public class CustomerGenre {
    private String name;
    private int numInvoices;

    public CustomerGenre(String name, int numInvoices) {
        this.name = name;
        this.numInvoices = numInvoices;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumInvoices() {
        return numInvoices;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfInvoices(int numInvoices) {
        this.numInvoices = numInvoices;
    }

    // To-string method
    @Override
    public String toString() {
        return "CustomerGenre{" +  "name='" + name + '\'' + ", numberOfInvoices=" + numInvoices + '}';
    }
}
