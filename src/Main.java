
public class Main {


    public static void main(String[] args) {

        System.out.println("Hello world!");

        double num1 = requestInputNumber();
        char oparation = requestInputChar();
        double num2 = requestInputNumber();
        double result = calculate(num1, num2, oparation);
        System.out.println("The result is: " + result);
    }

    /**
     * Method for prompting the user to enter a number
     * @return entered number
     */
    public static double requestInputNumber(){

        return 0;

    }

    /**
     * Method for requesting a char from the user. ex. +, -, /, *
     * @return the char
     */
    public static char requestInputChar(){
        return '+';
    }

    /**
     * Method for calculating the sum after a given operation.
     * @param a double
     * @param b double
     * @param operation char, operation to apply to a & b ex.  +, -, /, *
     * @return value after operation.
     */
    public static int calculate(double a, double b, char operation){
        return 0;
    }

}