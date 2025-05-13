package com.vemana.bankingapp;


import java.util.*;

public class BankingServiceImpl implements BankingService {
    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, Account> accounts = new HashMap<>();
    private Map<Integer, Transaction> transactions = new HashMap<>();
    private Map<Integer, Beneficiary> beneficiaries = new HashMap<>();
    
    private int transactionIdCounter = 1;

    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerID(), customer);
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountID(), account);
    }

    public void addTransaction(Transaction transaction) {
        transactions.put(transaction.getTransactionID(), transaction);
        Account acc = accounts.get(transaction.getAccountID());
        if (acc != null) {
            double newBalance = transaction.getType().equals("Deposit") ?
                acc.getBalance() + transaction.getAmount() :
                acc.getBalance() - transaction.getAmount();
            acc.setBalance(newBalance);
        }
    }

    public void addBeneficiary(Beneficiary beneficiary) {
        beneficiaries.put(beneficiary.getBeneficiaryID(), beneficiary);
    }

    public Customer findCustomerById(int id) {
        return customers.get(id);
    }

    public Account findAccountById(int id) {
        return accounts.get(id);
    }

    public Transaction findTransactionById(int id) {
        return transactions.get(id);
    }

    public Beneficiary findBeneficiaryById(int id) {
        return beneficiaries.get(id);
    }

    public List<Account> getAccountsByCustomerId(int customerId) {
        List<Account> result = new ArrayList<>();
        for (Account acc : accounts.values()) {
            if (acc.getCustomerID() == customerId) result.add(acc);
        }
        return result;
    }

    public List<Transaction> getTransactionsByAccountId(int accountId) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction tx : transactions.values()) {
            if (tx.getAccountID() == accountId) result.add(tx);
        }
        return result;
    }

    public List<Beneficiary> getBeneficiariesByCustomerId(int customerId) {
        List<Beneficiary> result = new ArrayList<>();
        for (Beneficiary b : beneficiaries.values()) {
            if (b.getCustomerID() == customerId) result.add(b);
        }
        return result;
    }
}
