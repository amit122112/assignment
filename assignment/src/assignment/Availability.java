package assignment;

import java.time.LocalDate;
import java.time.LocalTime;

public class Availability extends Employee {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate availableDate;

    // Constructor
    public Availability(String id, String name, LocalTime startTime, LocalTime endTime, LocalDate availableDate) {
        super(id, name); // Call the constructor of Employee
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableDate = availableDate;
    }

    // Getter for Start Time
    public LocalTime getStartTime() {
        return startTime;
    }

    // Setter for Start Time
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    // Getter for End Time
    public LocalTime getEndTime() {
        return endTime;
    }

    // Setter for End Time
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    // Getter for Available Date
    public LocalDate getAvailableDate() {
        return availableDate;
    }

    // Setter for Available Date
    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public static void main(String[] args) {
        // Example usage
        Availability employee = new Availability("1", "John Doe", LocalTime.of(9, 0), LocalTime.of(17, 0), LocalDate.of(2023, 5, 23));
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Role: " + employee.getRole());
        System.out.println("Employee Start Time: " + employee.getStartTime());
        System.out.println("Employee End Time: " + employee.getEndTime());
        System.out.println("Employee Available Date: " + employee.getAvailableDate());

        employee.setStartTime(LocalTime.of(10, 0));
        employee.setEndTime(LocalTime.of(18, 0));
        employee.setAvailableDate(LocalDate.of(2023, 5, 24));

        System.out.println("Updated Employee Start Time: " + employee.getStartTime());
        System.out.println("Updated Employee End Time: " + employee.getEndTime());
        System.out.println("Updated Employee Available Date: " + employee.getAvailableDate());
    }
}
