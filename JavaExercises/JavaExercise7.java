import java.util.Scanner;

public class JavaExercise7 {

   /*7. Write a Java program that takes a number as input and prints its multiplication table up to 10.
Test Data:
Input a number: 8
Expected Output :
8 x 1 = 8
8 x 2 = 16
8 x 3 = 24
...
8 x 10 = 80 */ 
    public static void main(String[] args) {

        Scanner takeNumber = new Scanner(System.in);
        System.out.println("Input a number: " );

        //read input

        int num1 = takeNumber.nextInt();
        // use loop to calculate the multiplication

        for(int i = 0; i < 10 ; i++) {

            System.out.println(num1 + " x " + (i + 1) + " = " + (num1 * (i + 1))); 
            // + means concstinate
            //(i + 1) means increase i by 1.
            // + = sign
            //num1 multiply i and increase by 1 each time

            
        }

        
    }
}
