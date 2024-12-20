/*
 * Add, edit, and retrieve customer data. Enables user to read/write data
 * to customers.csv
 */

package com.omm;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerManager {
    private List<Customer> customers;

    // Constructor
    public CustomerManager() {
        customers = new ArrayList<>();
        loadCustomerData(); // Loads data from the csv
    }

    // Add customer to the list and save to CSV
    public void addCustomer(String name, String address, String service, double price) {
        Customer customer = new Customer(name, address, service, price);
        customers.add(customer);  // Add to the list
        saveCustomerData(name, address, service, price);  // Save to CSV
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
        String service;
        double price;

        public Customer(String name, String address, String service, double price) {
            this.name = name;
            this.address = address;
            this.service = service;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Address: " + address + ", Service: " + service + ", Price: $" + price;
        }
    }

    // Saves customer data to the CSV file
    public void saveCustomerData(String name, String address, String service, double price) {
        try (FileWriter writer = new FileWriter("data/customers.csv", true)) { // 'true' allows appending data to the file
            writer.append(name)
                  .append(",")
                  .append(address)
                  .append(",")
                  .append(service)
                  .append(",")
                  .append(String.valueOf(price))
                  .append("\n"); // New line for each new customer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Loads customer data from the CSV file
    public void loadCustomerData() {
        File file = new File("data/customers.csv");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] customerData = line.split(",");
                    String name = customerData[0];
                    String address = customerData[1];
                    String service = customerData[2];
                    double price = Double.parseDouble(customerData[3]);

                    // Add to the customer list
                    customers.add(new Customer(name, address, service, price));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
