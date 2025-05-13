package com.vemana.bankingapp;


import java.util.*;

public class BankingSystemApp {
    public static void main(String[] args) {
        BankingService service = new BankingServiceImpl();

        Customer c1 = new Customer(1, "John", "New York", "1234567890");
        service.addCustomer(c1);

        Account a1 = new Account(101, 1, "Savings", 5000.0);
        service.addAccount(a1);

        Transaction t1 = new Transaction(1, 101, "Deposit", 1000.0);
        service.addTransaction(t1);

        Beneficiary b1 = new Beneficiary(1, 1, "Alice", "9876543210", "ABC Bank");
        service.addBeneficiary(b1);

        System.out.println("Customer Details: " + service.findCustomerById(1));
        System.out.println("Account Details: " + service.findAccountById(101));
        System.out.println("Transactions: " + service.getTransactionsByAccountId(101));
        System.out.println("Beneficiaries: " + service.getBeneficiariesByCustomerId(1));
    }
}
