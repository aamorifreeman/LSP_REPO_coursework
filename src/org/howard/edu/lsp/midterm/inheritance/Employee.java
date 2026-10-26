package org.howard.edu.lsp.midterm.inheritance;

/**
 * Common employee state and a polymorphic pay calculation contract.
 * @author Aamori Freeman (with disclosed OpenAI Codex assistance)
 */
public abstract class Employee {
    private final double hoursWorked;
    private final double hourlyRate;

    /**
     * Initializes the hours and rate shared by employee types.
     * @param hoursWorked nonnegative hours worked this week
     * @param hourlyRate nonnegative base hourly rate
     */
    protected Employee(double hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    /** @return hours worked this week */
    protected final double getHoursWorked() { return hoursWorked; }

    /** @return the base hourly rate */
    protected final double getHourlyRate() { return hourlyRate; }

    /** @return pay calculated according to this employee's employment type */
    public abstract double calculatePay();
}
