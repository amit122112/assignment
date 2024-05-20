package assignment;

//import assignment.Employee;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
	private static AuthenticationManager instance;
    private Map<String, String> userDatabase;
    public Map<String, Employee> employeeDatabase;

    public AuthenticationManager() {
        this.userDatabase = new HashMap<>();
        this.employeeDatabase = new HashMap<>();
        
        userDatabase.put("root", "root");
        employeeDatabase.put("User", new Employee("admin", "Admin User"));
    }
    
    public static synchronized AuthenticationManager getInstance() {
        if (instance == null) {
            instance = new AuthenticationManager();
        }
        return instance;
    }

    public boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
    
    public void inviteUser(String email, String tempPassword) {
        userDatabase.put(email, tempPassword);
        employeeDatabase.put(email, new Employee(email, email));
        sendEmail(email, tempPassword);
    }

    private void sendEmail(String to, String tempPassword) {
        System.out.println("You have been invited to join the Rostering Management System. Your temporary password is: " + tempPassword);
    }

    public void assignRole(String email, String role) {
        Employee employee = employeeDatabase.get(email);
        if (employee != null) {
            employee.setRole(role);
            System.out.println("Assigned role " + role + " to " + email);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteUser(String email) {
        userDatabase.remove(email);
        employeeDatabase.remove(email);
        System.out.println("Deleted user " + email);
    }

    public void updateUser(String email, String newName) {
        Employee employee = employeeDatabase.get(email);
        if (employee != null) {
            employee.setName(newName);
            System.out.println("Updated user " + email + " to " + newName);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public Employee getEmployee(String email) {
        return employeeDatabase.get(email);
    }
}
