package assignment;

import java.time.LocalDateTime;
//import assignment.Employee;

public class ScheduleManager {
    private Schedule schedule;

    public ScheduleManager() {
        this.schedule = new Schedule();
    }

    public void createShift(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        Shift shift = new Shift(startTime, endTime, employee);
        schedule.addShift(shift);
    }

    public Schedule getSchedule() {
        return schedule;
    }
}