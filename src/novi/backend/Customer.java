package novi.backend;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
    }

    // getters
    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    // add transactions
    public boolean addTransaction(Double newTransaction) {
        return this.transactions.add(newTransaction);
    }

    // show transactions
    public void printTransactions() {
        if(this.transactions.size() < 1) {
            System.out.println("No transactions");
        } else {
            for(int i = 0; i < this.transactions.size(); i++) {
                System.out.println(i+1 + ": €" + this.transactions.get(i));
            }
        }
    }

    // create customer
    public static Customer createCustomer(String name, Double startingAmount) {
        Customer customer = new Customer(name);

        if(customer.addTransaction(startingAmount)) {
            return customer;
        }
        return null;
    }

}
