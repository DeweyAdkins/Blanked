package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Bank> accounts = new ArrayList<>();


        Bank account1 = new Bank("Dewey", 5000.0);
        Bank account2 = new Bank("Tyler", 300.0);
        accounts.add(account1);
        accounts.add(account2);


        account1.withdraw(100.0);
        account2.deposit(100.0);


        System.out.println("Account1 Details: ");
        account1.printAccountDetails();
        System.out.println(account1);

        System.out.println("Account2 Details: ");
        account2.printAccountDetails();
        System.out.println(account2);


        Bank newAccount = new Bank();
        accounts.add(newAccount);

        // Displaying the main menu
        mainMenu(newAccount, accounts);

        scanner.close();
    }

    // Main menu method
    public static void mainMenu(Bank account, ArrayList<Bank> accounts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + account.getAccountHolderName() + "! What would you like to do?");
        while (true) {
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Current balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter account number to transfer to: ");
                    int targetAccountNumber = scanner.nextInt();
                    Bank targetAccount = null;
                    for (Bank acc : accounts) {
                        if (acc.getAccountNumber() == targetAccountNumber) {
                            targetAccount = acc;
                            break;
                        }
                    }
                    if (targetAccount != null) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        account.transfer(targetAccount, transferAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
