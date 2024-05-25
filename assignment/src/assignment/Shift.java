package assignment;

import java.time.LocalDateTime;

interface ShiftState {
    void startShift(Shift shift);
    void endShift(Shift shift);
}

class NotStartedState implements ShiftState {
    @Override
    public void startShift(Shift shift) {
        shift.setState(new InProgressState());
        System.out.println("Shift started.");
    }

    @Override
    public void endShift(Shift shift) {
        System.out.println("Cannot end a shift that hasn't started.");
    }
}

class InProgressState implements ShiftState {
    @Override
    public void startShift(Shift shift) {
        System.out.println("Shift is already in progress.");
    }

    @Override
    public void endShift(Shift shift) {
        shift.setState(new CompletedState());
        System.out.println("Shift ended.");
    }
}

class CompletedState implements ShiftState {
    @Override
    public void startShift(Shift shift) {
        System.out.println("Cannot start a shift that has already been completed.");
    }

    @Override
    public void endShift(Shift shift) {
        System.out.println("Shift is already completed.");
    }
}

public class Shift {
    LocalDateTime startTime;
    LocalDateTime endTime;
    Employee employee;
    private ShiftState state;

    public Shift(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.employee = employee;
        this.state = new NotStartedState(); // Initial state
    }

    public void setState(ShiftState state) {
        this.state = state;
    }

    public void startShift() {
        state.startShift(this);
    }

    public void endShift() {
        state.endShift(this);
    }
}
