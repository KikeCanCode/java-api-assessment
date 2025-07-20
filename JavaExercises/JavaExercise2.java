// public class JavaExercise2 {

// // Write a Java program to print the sum of two numbers. Test Data: 74 + 36
// public static void main (String[]args) {
//     int sum = 74 + 36;
//     System.out.println(sum);

// }
// }






// public class JavaExercise2 {

//     public static void main(String[] args) {
        
//         int number = 0;

//         // Check if number is greater than 0
//         if (number > 0) {
//             System.out.println("The number is positive.");
//         // Check if number is less than 0
//         } else if (number < 0) {
//             System.out.println("The number is negative.");
//         // If none of the above
//         } else {
//             System.out.println("The number is zero.");
//         }
//     }
// }


// public class JavaExercise2 {
// public static void main (String[]args) {
   
// // Declaring variables
// String name = "Kike";
// int age = 30;
// boolean isLearning = true;

// // Printing them out
// System.out.println("Name: " + name);
// System.out.println("Age: " + age);
// System.out.println("Learning Java: " + isLearning);

// }
// }


// public class Greetings {
//     public static void main(String[] args) {
//         sayHello();
//     }

//     public static void sayHello() {
//         System.out.println("Hello there!");
//     }
// }



// public class HelloName {
//     public static void main(String[] args) {
//         // Declare a variable to store name
//         String name = "Kike";

//         // Print greeting using the variable
//         System.out.println("Hello, " + name + "!");
//     }
// }


// import java.util.*;

// public class CollectionsExample {
//     public static void main(String[] args) {
//         // List allows duplicates and maintains order
//         List<String> fruits = new ArrayList<>();
//         fruits.add("Apple");
//         fruits.add("Banana");
//         fruits.add("Apple"); // duplicate allowed
//         System.out.println("List: " + fruits);

//         // Set stores unique elements only
//         Set<String> uniqueFruits = new HashSet<>(fruits);
//         System.out.println("Set: " + uniqueFruits);

//         // Map stores key-value pairs
//         Map<String, Integer> fruitCounts = new HashMap<>();
//         fruitCounts.put("Apple", 2);
//         fruitCounts.put("Banana", 1);
//         System.out.println("Map: " + fruitCounts);

//         // Stack (LIFO - Last In First Out)
//         Stack<String> bookStack = new Stack<>();
//         bookStack.push("Book 1");
//         bookStack.push("Book 2");
//         bookStack.push("Book 3");
//         System.out.println("Stack (Top item removed): " + bookStack.pop()); // Book 3
//         System.out.println("Stack (Remaining): " + bookStack);

//         // ArrayDeque used as a Stack (preferred over Stack class)
//         ArrayDeque<String> taskStack = new ArrayDeque<>();
//         taskStack.push("Task 1");
//         taskStack.push("Task 2");
//         taskStack.push("Task 3");
//         System.out.println("ArrayDeque (Top item removed): " + taskStack.pop()); // Task 3
//         System.out.println("ArrayDeque (Remaining): " + taskStack);
//     }
// }






// public class FileReadingExample {
//     public static void main(String[] args) {
//         try {
//             FileReader fr = new FileReader("example.txt"); 
//             BufferedReader br = new BufferedReader(fr);
//             String line;
//             while ((line = br.readLine()) != null) {
//                 System.out.println(line);
//             }
//             br.close(); // Always close your reader!
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }


// import java.io.FileWriter;
// import java.io.IOException;

// public class WriteToFileExample {
//     public static void main(String[] args) {
//         try {
//             FileWriter writer = new FileWriter("output.txt");
//             writer.write("Hello from my Java program!");
//             writer.close();
//             System.out.println("Successfully wrote to the file.");
//         } catch (IOException e) {
//             System.out.println("An error occurred.");
//             e.printStackTrace();
//         }
//     }
// }




// // Define the Car class
// class Car {

//     // Instance variables to store the car's properties
//     String colour; 
//     String brand;  
//     int speed;     

//     // Method to simulate starting the car
//     public void start() {
//         System.out.println("Car is starting...");
//     }
// }

// // Define the Main class with the main method
// public class Main {
//     public static void main(String[] args) {

//         // Create a new Car object
//         Car myCar = new Car();

//         // Set the properties of the car
//         myCar.colour = "Red";
//         myCar.brand = "Toyota";

//         // Call the start method on the car
//         myCar.start();

//     }
// }






// //Encapsulation – using getters and setters
// public class BankAccount {
//     private double balance;  // private = encapsulated

//     public double getBalance() {
//         return balance;
//     }

//     public void deposit(double amount) {
//         if(amount > 0) balance += amount;
//     }
// }


// //Abstraction – hiding the inner logic using abstract class

// public abstract class BankService {
//     public abstract void execute();
// }

// public class LoanService extends BankService {
//     @Override
//     public void execute() {
//         System.out.println("Approving loan...");
//     }
// }




// //Inheritance – extending from a base class

// public class Account {
//     protected String accountNumber;
// }

// public class SavingsAccount extends Account {
//     private double interestRate;
// }

// //Polymorphism – different behaviour using the same method

// public class Transaction {
//     public void process() {
//         System.out.println("Processing generic transaction...");
//     }
// }

// public class Deposit extends Transaction {
//     @Override
//     public void process() {
//         System.out.println("Processing deposit...");
//     }
// }


// public class JavaExercise2 {

//   public static void main(String[] args) {
// //Write the test first
// @Test
// public void testAddTwoNumbers() {
//     assertEquals(5, calculator.add(2, 3));
// }

// //Then I wrote the actual method to make the test pass
// public int add(int a, int b) {
//     return a + b;
//     }
// }










//Here’s a tiny example I worked on:
// public class Calculator {
//     public int add(int a, int b) {
//         return a + b;
//     }
// }



// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;



// //And a basic JUnit test for it:

// public class CalculatorTest {
//     @Test
//     public void testAdd() {
//         Calculator calculator = new Calculator();
//         assertEquals(5, calculator.add(2, 3));
//     }
// }
