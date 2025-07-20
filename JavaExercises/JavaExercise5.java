import java.util.Scanner;

public class JavaExercise5 {

/* 5. Write a Java program that takes two numbers as input and displays the product of two numbers.
Test Data:
Input first number: 25
Input second number: 5
Expected Output :
25 x 5 = 125 */

    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input frist number: "); // Prompts user to input number 
        int number1 = scanner.nextInt();// Reads and stores first number 

        System.out.print("Input second number: "); // Prompts user to input number
        int number2 = scanner.nextInt(); //Reads and stores the second number

        System.out.println(number1 * number2);
        
    //https://www.w3schools.com/java/java_user_input.asp

    //https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F/java/util/Scanner.html#method_summary

    }
}
   /*  //Solution 2
    // Declare and initialize static variables x and y
    int x = 25;

    // Calculate and print the product of x and y
    
    System.out.print(x * y);
25 */
