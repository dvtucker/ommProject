package com.omm;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class InvoiceManager {
    private List<Invoice> invoices;
    
    // Constructor
    public InvoiceManager() {
        invoices = new ArrayList<>();
        loadInvoiceData();  // Loads data from invoices.csv
    }

    // Add invoice for a customer and save to CSV
    public void addInvoice(String customerName, String service, double amount) {
        LocalDate date = LocalDate.now();  // Get current date
        Invoice invoice = new Invoice(customerName, service, amount, date, "No");
        invoices.add(invoice);
        saveInvoiceData(invoice);  // Save to invoices.csv
    }

    // Display all invoices
    public void displayInvoices() {
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    // Inner class for invoice details
    static class Invoice {
        String customerName;
        String service;
        double amount;
        LocalDate date;
        String paid;

        public Invoice(String customerName, String service, double amount, LocalDate date, String paid) {
            this.customerName = customerName;
            this.service = service;
            this.amount = amount;
            this.date = date;
            this.paid = paid;
        }

        @Override
        public String toString() {
            return "Customer: " + customerName + ", Service: " + service + ", Amount: $" + amount + ", Date: " + date + ", Paid: " + paid;
        }
    }

    // Saves invoice data to the CSV file
    public void saveInvoiceData(Invoice invoice) {
        try (FileWriter writer = new FileWriter("data/invoices.csv", true)) {
            writer.append(invoice.customerName)
                  .append(",")
                  .append(invoice.service)  // Add service to the CSV
                  .append(",")
                  .append(String.valueOf(invoice.amount))
                  .append(",")
                  .append(invoice.date.toString())  // Convert date to string format
                  .append(",")
                  .append(invoice.paid)
                  .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loads invoice data from the CSV file
    public void loadInvoiceData() {
        File file = new File("data/invoices.csv");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] invoiceData = line.split(",");
                    String customerName = invoiceData[0];
                    String service = invoiceData[1];  // Read service from CSV
                    double amount = Double.parseDouble(invoiceData[2]);
                    LocalDate date = LocalDate.parse(invoiceData[3]);
                    String paid = invoiceData[4];

                    invoices.add(new Invoice(customerName, service, amount, date, paid));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
