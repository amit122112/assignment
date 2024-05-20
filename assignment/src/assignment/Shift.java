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
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
