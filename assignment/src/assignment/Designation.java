package assignment;

public class Designation extends Employee {
    private String designation;

    // Constructor
    public Designation(String id, String name, String designation) {
        super(id, name,"",""); // Call the constructor of Employee
        this.designation = designation;
    }

    // Getter for Designation
    public String getDesignation() {
        return designation;
    }

    // Setter for Designation
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public static void main(String[] args) {
        // Example usage
        Designation employee = new Designation("1", "Santosh Panta", "Developer");
        employee.setName("Amit Basnet Employee");
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Role: " + employee.getRole());
        System.out.println("Employee Designation: " + employee.getDesignation());

        employee.setDesignation("Senior Developer");
        System.out.println("Updated Employee Designation: " + employee.getDesignation());
    }
}
