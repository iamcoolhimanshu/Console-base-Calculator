package ConsoleBaseCalculator;

import java.util.Scanner;
import java.lang.Math;

public class Calculator {

	public static double add(double num1, double num2) {
		return num1 + num2;
	}

	public static double subtract(double num1, double num2) {
		return num1 - num2;
	}

	public static double multiply(double num1, double num2) {
		return num1 * num2;
	}

	public static double divide(double num1, double num2) {
		if (num2 == 0) {
			System.out.println("Error: Cannot divide by zero.");
			return Double.NaN;
		}
		return num1 / num2;
	}

	public static double squareRoot(double num) {
		if (num < 0) {
			System.out.println("Error: Cannot calculate square root of a negative number.");
			return Double.NaN;
		}
		return Math.sqrt(num);
	}

	public static double exponentiate(double base, double exponent) {
		return Math.pow(base, exponent);
	}

	public static double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32) * 5 / 9;
	}

	public static void basicArithmeticMenu(Scanner scanner) {
		System.out.println("\n--- Basic Arithmetic ---");
		try {
			System.out.print("Enter first number: ");
			double num1 = scanner.nextDouble();
			System.out.print("Enter operator (+, -, *, /): ");
			String operator = scanner.next();
			System.out.print("Enter second number: ");
			double num2 = scanner.nextDouble();

			double result = 0;
			boolean validOp = true;

			switch (operator) {
			case "+":
				result = add(num1, num2);
				break;
			case "-":
				result = subtract(num1, num2);
				break;
			case "*":
				result = multiply(num1, num2);
				break;
			case "/":
				result = divide(num1, num2);
				break;
			default:
				System.out.println("Invalid operator!");
				validOp = false;
				break;
			}

			if (validOp && !Double.isNaN(result)) {
				System.out.printf("Result: %.2f %s %.2f = %.2f\n", num1, operator, num2, result);
			}

		} catch (java.util.InputMismatchException e) {
			System.out.println("Invalid input. Please enter valid numbers.");
			scanner.next();
		}
	}

	public static void scientificMenu(Scanner scanner) {
		System.out.println("\n--- Scientific Calculations ---");
		System.out.println("1. Square Root (sqrt)");
		System.out.println("2. Exponentiation (pow)");
		System.out.print("Choose an option: ");

		try {
			int choice = scanner.nextInt();
			double result = Double.NaN;

			switch (choice) {
			case 1:
				System.out.print("Enter number to find square root of: ");
				double num = scanner.nextDouble();
				result = squareRoot(num);
				if (!Double.isNaN(result)) {
					System.out.printf("Result: sqrt(%.2f) = %.2f\n", num, result);
				}
				break;
			case 2:
				System.out.print("Enter base number: ");
				double base = scanner.nextDouble();
				System.out.print("Enter exponent: ");
				double exp = scanner.nextDouble();
				result = exponentiate(base, exp);
				System.out.printf("Result: %.2f ^ %.2f = %.2f\n", base, exp, result);
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid option number.");
			scanner.next();
		}
	}

	public static void unitConversionMenu(Scanner scanner) {
		System.out.println("\n--- Unit Conversions ---");
		System.out.println("1. Temperature (Fahrenheit to Celsius)");
		System.out.print("Choose an option: ");

		try {
			int choice = scanner.nextInt();
			double result = Double.NaN;

			switch (choice) {
			case 1:
				System.out.print("Enter temperature in Fahrenheit: ");
				double fahr = scanner.nextDouble();
				result = fahrenheitToCelsius(fahr);
				System.out.printf("%.2f°F is equal to %.2f°C\n", fahr, result);
				break;
			default:
				System.out.println("Invalid choice or conversion not yet implemented.");
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid option number.");
			scanner.next();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		System.out.println("***********************************");
		System.out.println("*** Enhanced Console Calculator ***");
		System.out.println("***********************************");

		while (running) {
			System.out.println("\n--- Main Menu ---");
			System.out.println("1. Basic Arithmetic (+, -, *, /)");
			System.out.println("2. Scientific Calculations (sqrt, pow)");
			System.out.println("3. Unit Conversions (Temperature, etc.)");
			System.out.println("4. Exit");
			System.out.print("Enter your choice (1-4): ");

			if (scanner.hasNextInt()) {
				int menuChoice = scanner.nextInt();

				switch (menuChoice) {
				case 1:
					basicArithmeticMenu(scanner);
					break;
				case 2:
					scientificMenu(scanner);
					break;
				case 3:
					unitConversionMenu(scanner);
					break;
				case 4:
					System.out.println("Exiting Calculator. Thank you for using me!");
					running = false;
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 4.");
				}
			} else {
				System.out.println("Invalid input. Please enter a valid menu number.");
				scanner.next();
			}
		}
		scanner.close();
	}
}