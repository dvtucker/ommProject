package com.omm;  // Make sure this matches the package structure

public class Main {
    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();  // Use CustomerManager here
        
        // Add some customers to test
        manager.addCustomer("John Doe", "123 Main St", 7, 50.0);
        manager.addCustomer("Jane Smith", "456 Oak Ave", 14, 40.0);
    
        System.out.println("Customer List:");
        manager.displayCustomers();  // Display the customers
    }
}
