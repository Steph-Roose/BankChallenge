package novi.backend;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
	    boolean quit = false;
        int choice = 0;

        printMainMenu();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> printMainMenu();
                case 1 -> createBranch();
                case 2 -> showBranchesList();
                case 3 -> goToBranch();
                case 4 -> quit = true;
            }
        }

    }

    private static void printMainMenu() {
        System.out.println("Main menu");
        System.out.println("0. Show menu");
        System.out.println("1. Create new branch");
        System.out.println("2. Show list of branches");
        System.out.println("3. Switch to branch");
        System.out.println("4. Quit application");
    }

    private static void createBranch() {
        System.out.println("Enter the location of the new branch: ");
        String location = scanner.nextLine();

        if(bank.addBranch(location)) {
            System.out.println("Branch added");
        }
    }

    private static void showBranchesList() {
        bank.printBranches();
    }

    private static void goToBranch() {
        System.out.println("To which branch would you like to switch: ");
        String location = scanner.nextLine();

        if(bank.queryBranches(location) == null) {
            System.out.println("Branch does not exist");
        } else {
            Branch branch = bank.queryBranches(location);
            boolean back = false;
            int choice = 0;

            System.out.println("Current branch: " + location);
            printBranchMenu();
            while(!back) {
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0 -> printBranchMenu();
                    case 1 -> createCustomer(branch);
                    case 2 -> showCustomerList(branch);
                    case 3 -> createTransaction(branch);
                    case 4 -> showTransactionList(branch);
                    case 5 -> back = true;
                }
            }
        }

    }

    private static void printBranchMenu() {
        System.out.println("0. Show menu");
        System.out.println("1. Add new customer");
        System.out.println("2. Show list of customers");
        System.out.println("3. Add transaction to customer account");
        System.out.println("4. Show list of customer transactions");
        System.out.println("5. Go back to main menu");
    }

    private static void createCustomer(Branch branch) {
        System.out.println("Enter the name of the customer: ");
        String name = scanner.nextLine();
        System.out.println("Enter the initial balance of the customer: ");
        Double initialBalance = scanner.nextDouble();

        if(branch.addCustomer(name, initialBalance)) {
            System.out.println(name + " is added to the customer list");
        }
    }

    private static void showCustomerList(Branch branch) {
        branch.printCustomers();
    }

    private static void createTransaction(Branch branch) {
        System.out.println("Enter the name of the customer: ");
        String name = scanner.nextLine();
        System.out.println("Enter the new transaction: ");
        Double newTransaction = scanner.nextDouble();

        if(branch.addNewTransaction(name, newTransaction)) {
            System.out.println("€" + newTransaction + " is added to the transactions of " + name);
        }
    }

    private static void showTransactionList(Branch branch) {
        System.out.println("Enter the name of the customer: ");
        String name = scanner.nextLine();

        branch.printCustomerTransactions(name);
    }
}
