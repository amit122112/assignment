package assignment;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthenticationManager authManager = AuthenticationManager.getInstance();
        ScheduleManager scheduleManager = new ScheduleManager();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authManager.authenticate(username, password)) {
            System.out.println("Authentication successful!");
            Employee loggedInUser = authManager.getEmployee(username);

            if ("root".equals(username)) {
                adminMenu(scanner, authManager, scheduleManager);
            } else if ("user".equals(username)){
                userMenu(scanner, loggedInUser, scheduleManager);
            }
        } else {
            System.out.println("Authentication failed. Exiting...");
        }

        scanner.close();
    }

    private static void adminMenu(Scanner scanner, AuthenticationManager authManager, ScheduleManager scheduleManager) {
        String command;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Invite User");
            System.out.println("2. Manage Users");
            System.out.println("3. Manage Shifts");
            System.out.println("4. Generate Report");
            System.out.println("5. Manage Designation");
            System.out.println("6. Manage Availability");
            System.out.println("7. Logout");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter the username of the new user: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter a temporary password for the new user: ");
                    String tempPassword = scanner.nextLine();
                    authManager.inviteUser(email, tempPassword);
                    System.out.println("Invitation sent to " + email);
                    break;
                case "2":
                    manageUsers(scanner, authManager);
                    break;
                case "3":
                    manageShifts(scanner, authManager, scheduleManager);
                    break;
                case "4":
                    generateReport(authManager, scheduleManager);
                case "5":
                    manageDesignation(scanner, authManager, designation);
                case "6":
                    manageAvailability(scanner, authManager, availability);
                    break;
                case "7":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!"5".equals(command));
    }

    private static void userMenu(Scanner scanner, Employee loggedInUser, ScheduleManager scheduleManager) {
        String command;
        do {
            System.out.println("\nUser Menu:");
            System.out.println("1. View Shifts");
            System.out.println("2. Start Shift");
            System.out.println("3. End Shift");
            System.out.println("4. View Role");
            System.out.println("5. Logout");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    scheduleManager.getShiftsForEmployee(loggedInUser).forEach(shift ->
                            System.out.println("Shift: " + shift.startTime + " to " + shift.endTime));
                    break;
                case "2":
                    System.out.print("Enter start time (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Enter end time (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine());
                    scheduleManager.createShift(startTime, endTime, loggedInUser);
                    System.out.println("Shift started.");
                    break;
                case "3":
                    System.out.println("Ending current shift...");
                    // Implementation to end the shift for the user
                    break;
                case "4":
                    System.out.println("Role: " + loggedInUser.getRole());
                    break;
                case "5":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!"5".equals(command));
    }

    private static void manageUsers(Scanner scanner, AuthenticationManager authManager) {
        String command;
        do {
            System.out.println("\nManage Users:");
            System.out.println("1. Assign Role");
            System.out.println("2. Delete User");
            System.out.println("3. Update User");
            System.out.println("4. Back");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter the email of the user: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter the new role: ");
                    String role = scanner.nextLine();
                    authManager.assignRole(email, role);
                    break;
                case "2":
                    System.out.print("Enter the email of the user: ");
                    String emailToDelete = scanner.nextLine();
                    authManager.deleteUser(emailToDelete);
                    break;
                case "3":
                    System.out.print("Enter the email of the user: ");
                    String emailToUpdate = scanner.nextLine();
                    System.out.print("Enter the new name of the user: ");
                    String newName = scanner.nextLine();
                    authManager.updateUser(emailToUpdate, newName);
                    break;
                case "4":
                    System.out.println("Returning to admin menu.");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!"4".equals(command));
    }

    private static void manageShifts(Scanner scanner, AuthenticationManager authManager, ScheduleManager scheduleManager) {
        String command;
        do {
            System.out.println("\nManage Shifts:");
            System.out.println("1. Add Shift");
            System.out.println("2. Update Shift");
            System.out.println("3. Back");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter the email of the employee: ");
                    String email = scanner.nextLine();
                    Employee employee = authManager.getEmployee(email);
                    if (employee == null) {
                        System.out.println("Employee not found.");
                        break;
                    }
                    System.out.print("Enter start time (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Enter end time (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine());
                    scheduleManager.createShift(startTime, endTime, employee);
                    System.out.println("Shift added successfully.");
                    break;
                case "2":
                    System.out.print("Enter the shift index to update: ");
                    int shiftIndex = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the email of the new employee: ");
                    String newEmail = scanner.nextLine();
                    Employee newEmployee = authManager.getEmployee(newEmail);
                    if (newEmployee == null) {
                        System.out.println("Employee not found.");
                        break;
                    }
                    System.out.print("Enter new start time (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime newStartTime = LocalDateTime.parse(scanner.nextLine());
                    System.out.print("Enter new end time (YYYY-MM-DDTHH:MM): ");
                    LocalDateTime newEndTime = LocalDateTime.parse(scanner.nextLine());
                    scheduleManager.updateShift(shiftIndex, newStartTime, newEndTime, newEmployee);
                    System.out.println("Shift updated successfully.");
                    break;
                case "3":
                    System.out.println("Returning to admin menu.");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!"3".equals(command));
    }
    
    private static void manageDesignation(Scanner scanner, AuthenticationManager authManager, Designation designation) {
        String command;
        do {
            System.out.println("\nManage Designation:");
            System.out.println("1. Get Designation");
            System.out.println("2. Update Designation");
            System.out.println("3. Back");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter the email of the employee: ");
                    String email = scanner.nextLine();
                    System.out.println(designation.getDesignation());
                    break;
                case "2":
                    System.out.print("Enter the email of the employee: ");
                    String useremail = scanner.nextLine();
                    System.out.print("Enter the new designation of the employee: ");
                    String newDesignation = scanner.nextLine();
                    designation.setDesignation(newDesignation);

                    System.out.println("designation updated successfully.");
                    break;
                case "3":
                    System.out.println("Returning to admin menu.");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!"3".equals(command));
    }

    private static void manageAvailability(Scanner scanner, AuthenticationManager authManager, Availability availability) {
        String command;
        do {
            System.out.println("\nManage Availability:");
            System.out.println("1. Get Availability");
            System.out.println("2. Update Availability");
            System.out.println("3. Back");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter the email of the employee: ");
                    String email = scanner.nextLine();
                    System.out.println("Start Time: " + availability.getStartTime());
                    System.out.println("End Time: " + availability.getEndTime());
                    System.out.println("Date: " + availability.getAvailableDate());
                    break;
                case "2":
                    System.out.print("Enter the Start Time: ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter the End Time: ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter the Available date: ");
                    String newAvaiability = scanner.nextLine();
                    availability.setStartTime(startTime);
                    availability.setEndTime(endTime);
                    availability.setAvailableDate(newAvaiability);

                    System.out.println("Avaiability updated successfully.");
                    break;
                case "3":
                    System.out.println("Returning to admin menu.");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!"3".equals(command));
    }

    private static void generateReport(AuthenticationManager authManager, ScheduleManager scheduleManager) {
        System.out.println("\nReport:");
        System.out.println("Users and their roles:");
        for (Employee employee : authManager.employeeDatabase.values()) {
            System.out.println("Email: " + employee.getId() + ", Name: " + employee.getName() + ", Role: " + employee.getRole());
        }
        System.out.println("\nShifts:");
        scheduleManager.getShifts().forEach(shift -> {
            System.out.println("Shift: " + shift.startTime + " to " + shift.endTime + " for " + shift.employee.getName());
        });
    }
}
