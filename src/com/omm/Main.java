package com.omm; 

public class Main {
    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();  // Use CustomerManager here
        
        // Add some customers to test
        manager.addCustomer("Test Customer A", "21 Jump St", "Leaf cleanup", 50.0);
        manager.addCustomer("Test Customer B", "345 Sesame St", "trimming", 40.0);
    
        System.out.println("Customer List:");
        manager.displayCustomers();  // Display the customers
    }
}
