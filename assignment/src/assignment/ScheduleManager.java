package assignment;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleManager {
    private Schedule schedule;

    public ScheduleManager() {
        this.schedule = new Schedule();
    }

    public void createShift(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        Shift shift = new Shift(startTime, endTime, employee);
        schedule.addShift(shift);
    }

    
    public void updateShift(int shiftIndex, LocalDateTime newStartTime, LocalDateTime newEndTime, Employee newEmployee) {
        List<Shift> shifts = schedule.getShifts();
        if (shiftIndex >= 0 && shiftIndex < shifts.size()) {
            Shift shift = shifts.get(shiftIndex);
            shift.setStartTime(newStartTime);
            shift.setEndTime(newEndTime);
            shift.setEmployee(newEmployee);
            System.out.println("Shift updated successfully.");
        } else {
            System.out.println("Shift not found.");
        }
    }
    public Schedule getSchedule() {
        return schedule;
    }
}