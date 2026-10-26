package org.howard.edu.lsp.midterm.inheritance;

/**
 * A full-time employee earning time and a half beyond 40 weekly hours.
 * @author Aamori Freeman (with disclosed OpenAI Codex assistance)
 */
public class FullTimeEmployee extends Employee {
    /**
     * Creates this employee with the supplied hours and rate.
     * @param hoursWorked nonnegative hours worked this week
     * @param hourlyRate nonnegative base hourly rate
     */
    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /** @return this employee's weekly pay */
    @Override
    public double calculatePay() {
        return Math.min(getHoursWorked(), 40.0) * getHourlyRate()
                + Math.max(getHoursWorked() - 40.0, 0.0) * getHourlyRate() * 1.5;
    }
}
