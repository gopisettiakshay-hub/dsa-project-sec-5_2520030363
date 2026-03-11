package org.example;

import java.util.*;

public class Main {

    // Scanner object for user input
    static Scanner sc = new Scanner(System.in);

    // -----------------------------------------------------------
    // USER CLASS
    // Topic Used: Object Oriented Programming + Abstract Data Type Concept
    // This class acts like a simple ADT to store user credentials
    // -----------------------------------------------------------
    static class User {
        String username;
        String password;

        User(String u, String p) {
            username = u;
            password = p;
        }
    }

    // -----------------------------------------------------------
    // TRANSACTION CLASS
    // Topic Used: List ADT concept (each object acts like a node/item)
    // Used to store financial transaction information
    // -----------------------------------------------------------
    static class Transaction {

        int id;
        String type;
        double amount;
        int month;
        int year;

        Transaction(int id, String type, double amount, int month, int year) {
            this.id = id;
            this.type = type;
            this.amount = amount;
            this.month = month;
            this.year = year;
        }

        // Display transaction details
        void display() {
            System.out.println("ID: " + id +
                    " | Type: " + type +
                    " | Amount: " + amount +
                    " | Month: " + month +
                    " | Year: " + year);
        }
    }

    // -----------------------------------------------------------
    // DATA STORAGE
    // Topic Used: List ADT implementation using Array
    // -----------------------------------------------------------
    static User users[] = new User[50];
    static int userCount = 0;

    static Transaction arr[] = new Transaction[200];
    static int count = 0;

    // -----------------------------------------------------------
    // SIGN UP
    // Topic Used: List insertion operation (Array based list)
    // -----------------------------------------------------------
    static void signup() {

        System.out.println("\n--- Sign Up ---");

        System.out.print("Create Username: ");
        String u = sc.next();

        System.out.print("Create Password: ");
        String p = sc.next();

        // inserting user into list
        users[userCount++] = new User(u, p);

        System.out.println("Account Created Successfully\n");
    }

    // -----------------------------------------------------------
    // LOGIN
    // Topic Used: Searching Algorithm
    // Linear Search (O(n))
    // -----------------------------------------------------------
    static boolean login() {

        System.out.println("\n--- Login ---");

        System.out.print("Username: ");
        String u = sc.next();

        System.out.print("Password: ");
        String p = sc.next();

        // Linear Search to find matching user
        for (int i = 0; i < userCount; i++) {

            if (users[i].username.equals(u) &&
                    users[i].password.equals(p)) {

                System.out.println("Login Successful\n");
                return true;
            }
        }

        System.out.println("Invalid Login\n");
        return false;
    }

    // -----------------------------------------------------------
    // ADD TRANSACTION
    // Topic Used: List insertion operation
    // -----------------------------------------------------------
    static void addTransaction() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Type (Income/Expense): ");
        String type = sc.next();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Year: ");
        int year = sc.nextInt();

        // inserting transaction into list
        arr[count++] = new Transaction(id, type, amount, month, year);

        System.out.println("Transaction Added\n");
    }

    // -----------------------------------------------------------
    // VIEW HISTORY
    // Topic Used: List traversal
    // -----------------------------------------------------------
    static void viewHistory() {

        if (count == 0) {
            System.out.println("No Transactions\n");
            return;
        }

        System.out.println("\n--- Transaction History ---");

        // Traversing list
        for (int i = 0; i < count; i++) {
            arr[i].display();
        }

        System.out.println();
    }

    // -----------------------------------------------------------
    // MONTHLY INCOME CALCULATION
    // Topic Used: Traversal + Algorithm Analysis
    // Running Time: O(n)
    // -----------------------------------------------------------
    static void monthlyIncome() {

        System.out.print("Enter Month: ");
        int m = sc.nextInt();

        System.out.print("Enter Year: ");
        int y = sc.nextInt();

        double total = 0;

        for (int i = 0; i < count; i++) {

            if (arr[i].type.equalsIgnoreCase("Income")
                    && arr[i].month == m
                    && arr[i].year == y) {

                total += arr[i].amount;
            }
        }

        System.out.println("Monthly Income = " + total + "\n");
    }

    // -----------------------------------------------------------
    // YEARLY INCOME CALCULATION
    // Topic Used: Traversal + Running Time Analysis
    // -----------------------------------------------------------
    static void yearlyIncome() {

        System.out.print("Enter Year: ");
        int y = sc.nextInt();

        double total = 0;

        for (int i = 0; i < count; i++) {

            if (arr[i].type.equalsIgnoreCase("Income")
                    && arr[i].year == y) {

                total += arr[i].amount;
            }
        }

        System.out.println("Yearly Income = " + total + "\n");
    }

    // -----------------------------------------------------------
    // SORT TRANSACTIONS
    // Topic Used: Sorting Algorithm
    // Bubble Sort
    // Time Complexity: O(n²)
    // -----------------------------------------------------------
    static void sortTransactions() {

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - i - 1; j++) {

                if (arr[j].amount > arr[j + 1].amount) {

                    Transaction temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Transactions Sorted\n");
    }

    // -----------------------------------------------------------
    // SEARCH TRANSACTION
    // Topic Used: Searching Algorithm
    // Linear Search
    // -----------------------------------------------------------
    static void searchTransaction() {

        System.out.print("Enter Transaction ID: ");
        int key = sc.nextInt();

        // Linear search
        for (int i = 0; i < count; i++) {

            if (arr[i].id == key) {

                System.out.println("Transaction Found:");
                arr[i].display();
                System.out.println();
                return;
            }
        }

        System.out.println("Transaction Not Found\n");
    }

    // -----------------------------------------------------------
    // USER MENU
    // Topic Used: Control Structures + Algorithm Flow
    // -----------------------------------------------------------
    static void financeMenu() {

        int choice;

        do {

            System.out.println("----- Personal Finance System -----");
            System.out.println("1 Add Transaction");
            System.out.println("2 View History");
            System.out.println("3 Monthly Income");
            System.out.println("4 Yearly Income");
            System.out.println("5 Sort Transactions");
            System.out.println("6 Search Transaction");
            System.out.println("7 Logout");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTransaction();
                    break;

                case 2:
                    viewHistory();
                    break;

                case 3:
                    monthlyIncome();
                    break;

                case 4:
                    yearlyIncome();
                    break;

                case 5:
                    sortTransactions();
                    break;

                case 6:
                    searchTransaction();
                    break;

                case 7:
                    System.out.println("Logged Out\n");
                    break;

                default:
                    System.out.println("Invalid Choice\n");
            }

        } while (choice != 7);
    }

    // -----------------------------------------------------------
    // MAIN FUNCTION
    // Topic Used: Program Control + Menu Driven Algorithm
    // -----------------------------------------------------------
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("------ Welcome ------");
            System.out.println("1 Sign Up");
            System.out.println("2 Login");
            System.out.println("3 Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    signup();
                    break;

                case 2:
                    if (login())
                        financeMenu();
                    break;

                case 3:
                    System.out.println("Program Closed");
                    break;

                default:
                    System.out.println("Invalid Choice\n");
            }

        } while (choice != 3);
    }
}