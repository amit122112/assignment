package assignment;

public class Availability extends Employee {
    private String startTime;
    private String endTime;
    private String availableDate;

    // Constructor
    public Availability(String id, String name, String startTime, String endTime, String availableDate) {
        super(id, name,"","");
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableDate = availableDate;
    }

    // Getter for Start Time
    public String getStartTime() {
        return startTime;
    }

    // Setter for Start Time
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    // Getter for End Time
    public String getEndTime() {
        return endTime;
    }

    // Setter for End Time
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    // Getter for Available Date
    public String getAvailableDate() {
        return availableDate;
    }

    // Setter for Available Date
    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public static void main(String[] args) {
        // Example usage
        Availability employee = new Availability("1", "John Doe", "","","");
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Role: " + employee.getRole());
        System.out.println("Employee Start Time: " + employee.getStartTime());
        System.out.println("Employee End Time: " + employee.getEndTime());
        System.out.println("Employee Available Date: " + employee.getAvailableDate());

        employee.setStartTime("");
        employee.setEndTime("");
        employee.setAvailableDate("");

        System.out.println("Updated Employee Start Time: " + employee.getStartTime());
        System.out.println("Updated Employee End Time: " + employee.getEndTime());
        System.out.println("Updated Employee Available Date: " + employee.getAvailableDate());
    }
}
