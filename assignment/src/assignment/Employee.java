package assignment;

public class Employee {
	
	public String id;
    public String name;
    private String role;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
        this.role = "user";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }
}
