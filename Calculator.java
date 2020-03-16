import java.util.Scanner;
//Imported the scanner tool for the use of inputting variables later on//
public class Calculator {

    public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);
    //Set the variable for the Scanner to 'scnr' to allow the user to input values//
    double userInput1;
    double userInput2;
    int userOperation;
    /*These are the variables that the user will input, the first two being double to allow a wide range of input values,
    and the user operation being an integer since the user should only input 1-4 */
    System.out.print("Enter first operand: ");
    userInput1 = scnr.nextDouble();
    System.out.print("Enter second operand: ");
    userInput2 = scnr.nextDouble();
    //This is where the user will input the numbers they want to calculate//
    System.out.println("  ");
    System.out.println("Calculator Menu \n--------------- \n 1. Addition\n 2. Subtraction\n 3. Multiplication\n 4. Division");
    System.out.println("  ");
    // System.out.println("  ") is used to create an empty line, to space out the menu from the user-inputted values //
    System.out.print("Which operation do you want to perform? ");
    userOperation = scnr.nextInt();

    if (userOperation == 1) {
        System.out.println("The result of the operation is " + (userInput1 + userInput2) + ". Goodbye!");
    }
    else if (userOperation == 2) {
        System.out.println("The result of the operation is " + (userInput1 - userInput2) + ". Goodbye!");
    }
    else if (userOperation == 3) {
        System.out.println("The result of the operation is " + (userInput1 * userInput2) + ". Goodbye!");
    }
    else if (userOperation == 4) {
        System.out.println("The result of the operation is " + (userInput1 / userInput2) + ". Goodbye!");
    }
    else {
        System.out.println("Error: Invalid selection! Terminating program.");
    } /*The if/else statements above create a logic system that designates the values 1, 2, 3 and 4 to the mathematical
    operations in the calculator menu. The final statement is included if the user inputs a value that is *not* 1-4.*/
    }
}
//Partnered with Antonio today!//