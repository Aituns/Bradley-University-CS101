import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

/*
Write a Java program that repeatedly accepts two integers from the keyboard and prints the quotient to
the console. Your code must adhere to the follow specifications:
 - The user must enter 0 for both the numerator and denominator to exit the program.
 - You must read the input values using the Scanner’s next() method and then convert to a primitive integer using Integer.parseInt. 
   In case of an exception (when converting the string to an integer), the program must (1) print the corresponding stack trace (printStackTrace) 
   and (2) reset the Scanner object.
 - The program must catch division by zero exceptions and print a corresponding message in case
   one occurs. The error should not be printed if the user intends to exit. 
*/

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int numerator = 1;
        int denominator = 1;

        while (numerator != 0 || denominator != 0)
        {
            try {
                System.out.print("Enter two integers. (Enter zero in both spots to exit) \nNumerator: ");
                numerator = Integer.parseInt(scn.next());
                System.out.print("Denominator: ");
                denominator = Integer.parseInt(scn.next());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (numerator != 0 || denominator != 0)
                try {
                    int answer = numerator/denominator;
                    System.out.println("The answer is: " + answer);
                } catch (ArithmeticException e) {
                    System.out.println("You shouldn't divide a number by zero");
                }
            else
                System.out.println("Exiting");
            
        }
    }
}
