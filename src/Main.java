import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Print a greeting message when the program starts
        System.out.println("Hello world!");

        // Call the method to request the first number from the user
        double num1 = requestInputNumber();

        // Call the method to request a mathematical operator (+, -, /, *) from the user
        char operation = requestInputChar();

        // Call the method to request the second number from the user
        double num2 = requestInputNumber();

        // Call the calculate method to perform the operation between the two numbers
        double result = calculate(num1, num2, operation);

        // Display the result of the calculation to the user
        System.out.println("The result is: " + result);
    }

    /**
     * Method to prompt the user to enter a number.
     * This method continuously requests input until the user enters a valid number.
     * @return The valid number entered by the user as a double.
     */
    public static double requestInputNumber() {

        // A flag to track if a valid number has been entered
        Boolean hasNumber = false;

        // Variable to store the user's input number
        double num = 0;

        // Continue looping until the user enters a valid number
        while (!hasNumber) {

            // Prompt the user to input a number
            System.out.print("Enter a number: ");

            // Read the input from the user
            String input = scanner.nextLine();

            // Check if the input is not null (i.e., the user entered something)
            if (input != null) {

                // Trim any leading or trailing white spaces from the input
                input = input.trim();

                // Assume input is a valid number unless proven otherwise
                Boolean isDigit = true;

                // Loop through each character in the input to verify if it's a digit
                for (int i = 0; i < input.length(); i++) {

                    // Check if the current character is not a digit
                    if (!Character.isDigit(input.charAt(i))) {

                        // If a non-digit character is found, mark input as invalid
                        isDigit = false;

                        // Inform the user that the input is invalid
                        System.out.println("You entered an invalid value");

                        // Break out of the loop, no need to check further
                        break;
                    }
                }

                // If the input consists only of digits
                if (isDigit) {
                    // Set the flag to true to exit the loop
                    hasNumber = true;

                    // Convert the valid input string to a double and return it
                    return Double.parseDouble(input);
                }

            }

        }

        // This will never be reached because of the loop,
        // but it's good practice to include it
        return num;
    }

    /**
     * Method to request a mathematical operator from the user.
     * This method will keep asking the user to input a valid operator until they provide one.
     * Valid operators include: +, -, /, *
     * @return The valid operator entered by the user as a char.
     */
    public static char requestInputChar() {

        // A flag to track if a valid operator has been entered
        Boolean hasChar = false;

        // Variable to store the user's input operator, initialized to a default value ('+')
        char operation = '+';

        // Loop until the user enters a valid operator
        while (!hasChar) {

            // Prompt the user to input a mathematical operator
            System.out.print("Enter a math operator (+,-,/,*): ");

            // Read the user's input as a string
            String input = scanner.nextLine();

            // Check if the input is not null (i.e., the user entered something)
            if (input != null) {
                // Trim any leading or trailing white spaces from the input
                input = input.trim();

                // Check if the input matches one of the valid operators: +, -, /, *
                if (input.equals("+") || input.equals("-") || input.equals("/") || input.equals("*")) {
                    // If the input is a valid operator, set the flag to true to exit the loop
                    hasChar = true;

                    // Assign the input operator to the 'operation' variable
                    operation = input.charAt(0);
                } else {
                    // Inform the user that the input is invalid
                    System.out.println("You entered an invalid value");
                }
            }

        }

        // Return the valid operator entered by the user
        return operation;
    }

    /**
     * Method to calculate the result of a given operation between two numbers.
     * The operation can be addition (+), subtraction (-), division (/), or multiplication (*).
     * @param a First number (double)
     * @param b Second number (double)
     * @param operation The mathematical operation to apply to 'a' and 'b' (char). Example: '+', '-', '/', '*'.
     * @return The result of the operation as a double.
     */
    public static double calculate(double a, double b, char operation) {

        // Variable to store the result of the operation
        double result = 0;

        // Use a switch statement to perform the appropriate operation
        switch (operation) {
            case '+':
                // Call the Add class's add method to add 'a' and 'b'
                result = Add.add(a, b);
                break;  // Don't forget to break after each case

            case '-':
                // Call the Minus class's minus method to subtract 'b' from 'a'
                result = Minus.minus(a, b);
                break;

            case '/':
                // Call the Divide class's divide method to divide 'a' by 'b'
                // You may want to add a check to avoid division by zero
                if (b != 0) {
                    result = Divide.divide(a, b);
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;

            case '*':
                // Call the Multiply class's multiply method to multiply 'a' and 'b'
                result = Multiply.multiply(a, b);
                break;

            default:
                // If an invalid operator is entered, print an error message
                System.out.println("You entered an invalid value or operator");
                break;
        }

        // Return the result of the operation
        return result;
    }


}