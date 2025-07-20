import java.util.Scanner;

public class JavaExercise6 {
/* 6. Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers.
Test Data:
Input first number: 125
Input second number: 24
Expected Output :
125 + 24 = 149
125 - 24 = 101
125 x 24 = 3000
125 / 24 = 5
125 mod 24 = 5*/

    public static void main (String[]args) {
       
        Scanner inputNumber = new Scanner(System.in); // Creates a Scanner Object to read input from user
    
        System.out.print("Input first number"); // Prompt the user to input the first number
        int firstNumber = inputNumber.nextInt();

        System.out.println("input the secondNumber");
        int secondNumber = inputNumber.nextInt();

        System.out.println(firstNumber + secondNumber);

// Calculate and print the remainder of the division of the two numbers

System.out.println(firstNumber + " mod " + secondNumber+ " = " + (firstNumber % secondNumber));

    }

}
