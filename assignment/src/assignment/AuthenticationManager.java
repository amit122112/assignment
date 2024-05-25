package assignment;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private static AuthenticationManager instance = null;
    Map<String, Employee> employeeDatabase = new HashMap<>();

    private AuthenticationManager() {
        // Adding a default admin user
        employeeDatabase.put("root", new Employee("root", "admin@admin.com", "root", "Admin"));
        employeeDatabase.put("user", new Employee("user","user@user.com","user","User"));
        employeeDatabase.put("santosh", new Employee("santosh","santosh@user.com","santosh","User"));
        employeeDatabase.put("amit", new Employee("amit","amit@user.com","amit","User"));
    }

    public static AuthenticationManager getInstance() {
        if (instance == null) {
            instance = new AuthenticationManager();
        }
        return instance;
    }

    public boolean authenticate(String username, String password) {
   
        Employee employee = employeeDatabase.get(username);
        return employee != null && employee.getPassword().equals(password);
    }

    public void inviteUser(String email, String tempPassword) {
        // Simple user invitation (creation) for demo purposes
        employeeDatabase.put(email, new Employee(email, email, tempPassword, "User"));
    }

    public void assignRole(String email, String role) {
        Employee employee = employeeDatabase.get(email);
        if (employee != null) {
            employee.setRole(role);
        }
    }

    public void deleteUser(String email) {
        employeeDatabase.remove(email);
    }

    public void updateUser(String email, String newName) {
        Employee employee = employeeDatabase.get(email);
        if (employee != null) {
            employee.setName(newName);
        }
    }

    public Employee getEmployee(String email) {
        return employeeDatabase.get(email);
    }
}
