import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Variables
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;
        int principle;
        int years;
        int numberOfPayments;
        double mortgage;
        double annualInterest;
        double monthlyInterest;
        String mortgageOutput;
        Scanner scanner = new Scanner(System.in);

        //Display welcome
        System.out.println("====================");
        System.out.println("Mortgage Calculator");
        System.out.println("====================");

        //Get user input
        System.out.print("Enter Principle amount: ");
        principle = scanner.nextInt();

        System.out.print("Enter Annual Interest Rate: ");
        annualInterest = scanner.nextDouble();
        monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Enter Period (Years):  ");
        years = scanner.nextInt();
        numberOfPayments = years * MONTHS_IN_YEAR;

        //Calculate mortgage payments
        mortgage = principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        //Display results
        mortgageOutput = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageOutput);
        System.out.println("====================");





    }
}