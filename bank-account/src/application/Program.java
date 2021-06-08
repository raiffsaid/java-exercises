package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account;

        System.out.print("Enter the account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the account holder: ");
        String holder = sc.nextLine();

        System.out.print("Is there an initial deposit (y/n)? ");
        char answer = sc.next().charAt(0);
        sc.nextLine();

        if (answer == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(accountNumber, holder, initialDeposit);
        } else {
            account = new Account(accountNumber, holder);
        }

        System.out.println();

        System.out.println("Account data:");
        System.out.println(account);

        System.out.println();

        System.out.print("Enter a deposit value: ");
        account.deposit(sc.nextDouble());

        System.out.println("Updated account data:");
        System.out.println(account);

        System.out.println();

        System.out.print("Enter a withdraw value: ");
        account.withdraw(sc.nextDouble());

        System.out.println("Updated account data:");
        System.out.println(account);

        sc.close();
    }
}
