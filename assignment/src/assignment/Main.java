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
        AuthenticationManager authManager = new AuthenticationManager();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authManager.authenticate(username, password)) {
            System.out.println("Authentication successful!");

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