package novi.backend;

import java.util.ArrayList;

public class Branch {
    private String location;
    private ArrayList<Customer> customers;

    public Branch(String location) {
        this.location = location;
        this.customers = new ArrayList<Customer>();
    }

    // getters
    public String getLocation() {
        return location;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // add new customer + initial transaction amount
    public boolean addCustomer(String name, Double startingAmount) {
        if(findCustomer(name) >= 0) {
            System.out.println("Customer already exists");
            return false;
        } else {
            Customer customer = Customer.createCustomer(name, startingAmount);
            if(customer == null) {
                System.out.println("Could not add customer");
                return false;
            } else {
                this.customers.add(customer);
                return true;
            }
        }
    }

    // add additional transactions for customer
    public boolean addNewTransaction(String name, Double transaction) {
        int position = findCustomer(name);

        if(position < 0) {
            System.out.println("Customer not found");
            return false;
        } else {
            customers.get(position).addTransaction(transaction);
            return true;
        }
    }

    // show list of customers
    public void printCustomers() {
        for(int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println(i+1 + ". " + customer.getName() + " - " + customer.getTransactions().size() + " transactions");
        }
    }

    // show transactions of specific customer
    public void printCustomerTransactions(String name) {
        int position = findCustomer(name);

        if(position < 0) {
            System.out.println("Customer not found");
        } else {
            customers.get(position).printTransactions();
        }
    }

    // find customer
    private int findCustomer(String name) {
        for(int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if(customer.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // create branch
    public static Branch createBranch(String location) {
        return new Branch(location);
    }
}
