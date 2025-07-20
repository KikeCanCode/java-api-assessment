
import java.io.BufferedReader;
import java.util.Scanner;

public class ConditionalStatament {
/*
1. Check Positive or Negative Number

Write a Java program to get a number from the user and print whether it is positive or negative.

Test Data
Input number: 35
Expected Output :
Number is positive*/  
//  public static void main(String[] args)
//     {
//     Scanner scanner = new Scanner(System.in);

//     System.out.print("input nummber: ");

//     int input = scanner.nextInt();
 
//     if ( input > 0 ) {
//         System.out.println("Number is positivetive");
//     } else if ( input < 0 ) {
//         System.out.println( "Number is negative");
//     }
//     else {
//         System.out.println("Number is zer");
//         }
//     }
// }

/*3. Find Greatest Among Three Numbers

Write a Java program that takes three numbers from the user and prints the greatest number.

Test Data
Input the 1st number: 25
Input the 2nd number: 78
Input the 3rd number: 87
Expected Output :
The greatest: 87 */

    // public static void main(String[] args) {
    
//     Scanner scanner = new Scanner(system.in);

//     System.out.print("Enter your first number: ");
//     int input1 = scanner.nextInt();

//     System.out.print("Enter your second number: ");
//     int input2 = scanner.nextInt();

//     System.out.print("Enter your third number: ");
//     int input3 = scanner.nextInt();

//     if (input1 > input2); 
//     if (input1 > input3);
//         System.out.println(" The greatest: " + input1);
    
//     if (input2 > input1)
//     if (input2 > input3)
//     System.out.println("The greatest: " + input2);
   
//     if (input3 > input1)
//     if (input3 > input2)
//     System.out.println("The greatest: " + input3);

/*4. Check Positive, Negative, or Zero (with Range)

Write a Java program that reads a floating-point number 
and prints "zero" if the number is zero. Otherwise, 
print "positive" or "negative". Add "small" if the absolute 
value of the number is less than 1, or "large" if it exceeds
 1,000,000.

Test Data
Input a number: 25
Expected Output :
Input value: 25
Positive number */

//   public static void main(String[] args) {

//     Scanner scanner = new Scanner(System.in);
//     System.out.print("Enter your number: ");
//     double input = scanner.nextDouble();


// if ( input > 0 ) {
//     if(input < 1) {
//         System.out.println("Positive small number");
//     }
//     else if (input > 100000) {
//         System.out.println("positive large number");
//     }
//     else {
//         System.out.println("Positive number");
//     }
// }

// else if ( input < 0) {

//     if (Math.abs(input ) < 1) {

//     System.out.println("Negative small number");
//     }
//             else if (Math.abs(input) > 1000000)
//             {
                
//                 System.out.println("Negative large number");
//             }

//         else { 
//                 System.out.println("Negative number");


//             }  
//         }
//             else {


//             System.out.println("Zero");
//         }
//     }

// 

/* 5. Weekday Name from Number

Write a Java program that takes a number from 
the user and generates an integer between 1 and 7. 
It displays the weekday name.

Test Data
Input number: 3
Expected Output :
Wednesday */
//  public static void main(String[] args) {

//     //create scanner object  
//     Scanner scanner = new Scanner(System.in);

//   //Print input message 
//     System.out.print("Enter a number: ");
//     // Declare variable

//     int day = scanner.nextInt();

//     System.out.println(getDayName(day)); 


//     }
  
//  public static String getDayName(int day) {
//     String dayName = "";
//     switch (day) {
//         case 1: dayName = "Monday"; 
//         break;
//         case 2: dayName = "Tuesday"; 
//         break;
//         case 3: dayName = "Wednesday";
//          break;

//         case 4: dayName = "Thursday"; break;
//         case 5: dayName = "Friday"; 
//         break;
//         case 6: dayName = "Saturday"; 
//         break;
//         case 7: dayName = "Sunday"; 
//         break;

//         default:dayName = "Invalid day range";
//         }

//         return dayName;

//     }

/* 6. Compare Floats Up to Three Decimals

Write a Java program that reads two floating-point 
numbers and tests whether they are the same up to three 
decimal places.

Test Data
Input floating-point number: 25.586
Input floating-point another number: 25.589
Expected Output:
They are different */

// read  - scanner object
public static void main(String[] args) {
    

Scanner scanner = new Scanner(System.in);
// print message 

System.out.print("Enter a floating-point number: ");

//declare var1
double float1 = scanner.nextDouble();
// print message
System.out.printf("Enter a float number: ");
//declare variable2
float float2 = scanner.nextDouble();

flaot1= Math.round(flaot1* 1000);
        flaot1= flaot1/ 1000;

        float2 = Math.round(float2 * 1000);
        float2 = float2 / 1000;
// compare - if stament
if ( flaot1 == float2) {
    System.out.println(" The are the same")
} else  {
    Sytem.out.println("They are different");

}

 



    
 }





}


