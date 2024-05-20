package assignment;

//import assignment.Authentication;
//import assignment.ScheduleManager;
//import assignment.Employee;
//import assignment.Shift;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthenticationManager authManager =  AuthenticationManager.getInstance();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authManager.authenticate(username, password)) {
            System.out.println("Authentication successful!");
            
            if ("root".equals(username)) {
                System.out.println("Welcome, Admin. Do you want to invite a new user? (yes/no)");
                String response = scanner.nextLine();
                if ("yes".equalsIgnoreCase(response)) {
                    System.out.print("Enter the email of the new user: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter a temporary password for the new user: ");
                    String tempPassword = scanner.nextLine();
                    System.out.println("Invitation sent to " + email + " with password " + tempPassword);
                }
            }

            // Continue with the rest of the application
            ScheduleManager scheduleManager = new ScheduleManager();
            Employee employee = new Employee("E001", "John Doe");
            scheduleManager.createShift(LocalDateTime.of(2024, 5, 20, 9, 0), LocalDateTime.of(2024, 5, 20, 17, 0), employee);

            scheduleManager.getSchedule().getShifts().forEach(shift -> {
                System.out.println("Shift: " + shift.startTime + " to " + shift.endTime + " for " + shift.employee.name);
            });
        } else {
            System.out.println("Authentication failed. Exiting...");
        }

        scanner.close();
    }
}