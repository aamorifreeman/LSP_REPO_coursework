package org.howard.edu.lsp.midterm.inheritance;

/**
 * A contractor earning a 15 percent premium for every hour.
 * @author Aamori Freeman (with disclosed OpenAI Codex assistance)
 */
public class Contractor extends Employee {
    /**
     * Creates this employee with the supplied hours and rate.
     * @param hoursWorked nonnegative hours worked this week
     * @param hourlyRate nonnegative base hourly rate
     */
    public Contractor(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /** @return this employee's weekly pay */
    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate() * 1.15;
    }
}
