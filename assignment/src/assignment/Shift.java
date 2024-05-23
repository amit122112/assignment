package assignment;

import java.time.LocalDateTime;

public class Shift {
    LocalDateTime startTime;
    LocalDateTime endTime;
    Employee employee;

    public Shift(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.employee = employee;
    }
}
