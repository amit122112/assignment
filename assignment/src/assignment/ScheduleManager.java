package assignment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleManager {
    private List<Shift> shifts = new ArrayList<>();

    public void createShift(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        shifts.add(new Shift(startTime, endTime, employee));
    }

    public void updateShift(int index, LocalDateTime newStartTime, LocalDateTime newEndTime, Employee newEmployee) {
        if (index >= 0 && index < shifts.size()) {
            shifts.set(index, new Shift(newStartTime, newEndTime, newEmployee));
        }
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public List<Shift> getShiftsForEmployee(Employee employee) {
        return shifts.stream()
                .filter(shift -> shift.employee.equals(employee))
                .collect(Collectors.toList());
    }
}
