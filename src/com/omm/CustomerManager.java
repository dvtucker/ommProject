package com.omm;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerManager {
    private List<Customer> customers;

    // Constructor
    public CustomerManager() {
        customers = new ArrayList<>();
    }

    // Add customer to the list and save to CSV
    public void addCustomer(String name, String address, int frequency, double price) {
        Customer customer = new Customer(name, address, frequency, price);
        customers.add(customer);  // Add to the list
        saveCustomerData(name, address, frequency, price);  // Save to CSV
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

    // Method to save customer data to the CSV file
    public void saveCustomerData(String name, String address, int frequency, double price) {
        try (FileWriter writer = new FileWriter("data/customers.csv", true)) { // 'true' allows appending data to the file
            writer.append(name)
                  .append(",")
                  .append(address)
                  .append(",")
                  .append(String.valueOf(frequency))
                  .append(",")
                  .append(String.valueOf(price))
                  .append("\n"); // New line for each new customer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
