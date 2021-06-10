package application;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Annual income: ");
            Double annualIncome = sc.nextDouble();

            if (type == 'i') {
                System.out.print("Health expenditures: ");
                Double health = sc.nextDouble();

                list.add(new NaturalPerson(name, annualIncome, health));
            } else {
                System.out.print("Number of employees: ");
                Integer employees = sc.nextInt();

                list.add(new LegalPerson(name, annualIncome, employees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");

        for (TaxPayer taxPayer : list) {
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
        }

        double totalTaxes = 0.0;
        for (TaxPayer taxPayer : list) {
            totalTaxes += taxPayer.tax();
        }

        System.out.println();
        System.out.print("TOTAL TAXES: $" + String.format("%.2f", totalTaxes));

        sc.close();
    }
}
