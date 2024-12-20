package com.omm;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;

    // Constructor
    public CustomerManager() {
        customers = new ArrayList<>();
    }

    // Add customer
    public void addCustomer(String name, String address, int frequency, double price) {
        customers.add(new Customer(name, address, frequency, price));
    }

    // Display all customers
    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Inner class for customer details
    static class Customer {
        String name;
        String address;
        int frequency;
        double price;

        public Customer(String name, String address, int frequency, double price) {
            this.name = name;
            this.address = address;
            this.frequency = frequency;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Address: " + address + ", Frequency: " + frequency + ", Price: $" + price;
        }
    }

  /*   public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();

        // Add some customers to test
        manager.addCustomer("Alice", "123 Greenway Blvd", 7, 50.0);
        manager.addCustomer("Bob", "456 Elm St", 14, 40.0);

        System.out.println("Customer List:");
        manager.displayCustomers();
    } */
}
