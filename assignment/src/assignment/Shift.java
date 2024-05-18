package assignment;

//import assignment.Employee;
import java.time.LocalDateTime;

public class Shift {
	
	public LocalDateTime startTime;
    public LocalDateTime endTime;
    public Employee employee;

    public Shift(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.employee = employee;
    }

}
