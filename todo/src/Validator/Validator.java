package Validator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Validator {

    public static int wrongInputAndRange(List todos, Scanner scanner) {

        int number = 0;
        boolean isValid = true;

        while (isValid) {

            System.out.println("Enter number of the task:");

            try {
                number = scanner.nextInt();
                scanner.nextLine();
                    if (number < 1 || number > todos.size()) {
                        System.out.println("Task with such number does not exist!");
                    } else {
                        isValid = false;
                    }
            } catch (InputMismatchException e) {
                System.out.println("Expected number! Try again");
                scanner.nextLine();
            }
        }
        return number;
    }

    public static int readInt(Scanner scanner) {

        int number = 0;
        boolean isValid = true;

        while (isValid) {

            System.out.println("Enter number:");

            try {
                number = scanner.nextInt();
                scanner.nextLine();
                isValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Expected number! Try again");
                scanner.nextLine();
            }
        }
        return number;
    }

    public static String readString(Scanner scanner) {

        String name = "";
        boolean isValid = true;

        while (isValid) {

            System.out.println("Enter name:");

            name = scanner.nextLine();
            if (name.length() != 0) {
                isValid = false;
            } else {
                System.out.println("Expected name! Try again");
            }
        }
        return name;
    }
}
