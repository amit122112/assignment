package assignment;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
	private List<Shift> shifts;

    public Schedule() {
        this.shifts = new ArrayList<>();
    }

    public void addShift(Shift shift) {
        shifts.add(shift);
    }

    public List<Shift> getShifts() {
        return shifts;
    }

}
