package assignment;

import java.util.Scanner;

public class Authentication {

    private static String Username = "root";
    private static String Password = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String givenUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String givenPassword = scanner.nextLine();

        if (Username.equals(givenUsername) && Password.equals(givenPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }

        scanner.close();
    }
}
