package org.example;

import java.util.Scanner;

public class Bank {
    private double balance;
    private String accountHolderName;
    private int accountNumber;
    private static int accountCounter = 1;

    // Constructor with parameters
    public Bank(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountNumber = accountCounter++;
    }


    public Bank() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the account holder's name: ");
        this.accountHolderName = scanner.nextLine();
        System.out.print("Enter the starting balance: ");
        this.balance = scanner.nextDouble();
        this.accountNumber = accountCounter++;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdrawal method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    // Transfer method
    public void transfer(Bank targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("Transferred: $" + amount + " to account " + targetAccount.getAccountNumber());
        } else {
            System.out.println("Transfer amount invalid or exceeds current balance.");
        }
    }

    // Method to print account details
    public void printAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
        System.out.println("Account Number: " + accountNumber);
    }

    // Getters
    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // Overriding the toString() method to print account details
    @Override
    public String toString() {
        return "Account Holder: " + accountHolderName + ", Balance: $" + balance + ", Account Number: " + accountNumber;
    }
}