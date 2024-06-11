package saf.lexicon.java2;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

    public class CurrencyConverterApp {
        private static final Scanner scanner = new Scanner(System.in);
        private static final DecimalFormat df = new DecimalFormat("0.00");
        private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        public static void main(String[] args) {
            while (true) {
                displayMenu();
                int choice = getChoice();
                if (choice == 5
                ) {
                    System.out.println("Exiting the program...");
                    break;
                }
                handleConversion(choice);
            }
        }

        private static void displayMenu() {
            System.out.println("\nCurrency Converter Menu:");
            System.out.println("1. Convert SEK to USD");
            System.out.println("2. Convert USD to SEK");
            System.out.println("3. Convert SEK TO EURO");
            System.out.println("4. Convert EURO TO SEK");

            System.out.println("5 Exit");
            System.out.print("Enter your choice: ");
        }

        private static int getChoice() {
            while (true) {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice >= 1 && choice <= 4) {
                        return choice;
                    } else {
                        System.out.print("Invalid choice. Enter a number between 1 and 5: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Enter a number between 1 and 5: ");
                }
            }
        }

        private static void handleConversion(int choice) {
            System.out.print("Enter the amount: ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a positive number.");
                return;
            }

            double result = 0;
            String fromCurrency = "", toCurrency = "";

            switch (choice) {
                case 1:
                    fromCurrency = "SEK";
                    toCurrency = "USD";
                    result = CurrencyConverter.convert(amount, fromCurrency, toCurrency);
                    break;
                case 2:
                    fromCurrency = "USD";
                    toCurrency = "SEK";
                    result = CurrencyConverter.convert(amount, fromCurrency, toCurrency);
                    break;
                case 3:
                    fromCurrency = "SEK";
                    toCurrency = "EURO";
                    result = CurrencyConverter.convert(amount, fromCurrency, toCurrency);
                    break;
                case 4:
                    fromCurrency = "EURO";
                    toCurrency = "SEK";
                    result = CurrencyConverter.convert(amount, fromCurrency, toCurrency);
                    break;
            }

            LocalDateTime now = LocalDateTime.now();
            System.out.println("Conversion result: " + df.format(amount) + " " + fromCurrency + " = " + df.format(result) + " " + toCurrency);
            System.out.println("Conversion performed on: " + dtf.format(now));
        }
    }


