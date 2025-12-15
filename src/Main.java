import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Variables
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;
        int principal;
        int years;
        int numberOfPayments;
        double mortgage;
        double annualInterest;
        double monthlyInterest;
        String mortgageOutput ;
        Scanner scanner = new Scanner(System.in);

        //Display welcome
        System.out.println("====================");
        System.out.println("Mortgage Calculator");
        System.out.println("====================");

        //Get input
        while(true){
            System.out.print("Enter Principal amount ($1K - $1M): ");
            principal = scanner.nextInt();

            //validation check
            if(principal >= 100 && principal <= 1_000_000){
                break;
            }
            System.out.println("Please enter a value between 1000 and 1000000");
        }

        //Get input
        while(true){
            System.out.print("Enter Annual Interest Rate: ");
            annualInterest = scanner.nextDouble();

            //validation check
            if(annualInterest >= 1 && annualInterest <= 30){
                break;
            }
            System.out.println("Please enter a value between 1 and 30");
        }

        //Get input
        while(true) {
            System.out.print("Enter Period (Years):  ");
            years = scanner.nextInt();

            //validation check
            if(years >= 1 && years <= 35) {
                break;
            }
            System.out.println("Please enter a value between 1 and 30");
        }

        //Calculations
        numberOfPayments = years * MONTHS_IN_YEAR;
        monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        //Display results
        mortgageOutput = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("====================");
        System.out.println("Mortgage: " + mortgageOutput);
        System.out.println("====================");

        //Closures
        scanner.close();

    }
}