package org.howard.edu.lsp.midterm.inheritance;

/**
 * A part-time employee earning straight hourly pay for every hour.
 * @author Aamori Freeman (with disclosed OpenAI Codex assistance)
 */
public class PartTimeEmployee extends Employee {
    /**
     * Creates this employee with the supplied hours and rate.
     * @param hoursWorked nonnegative hours worked this week
     * @param hourlyRate nonnegative base hourly rate
     */
    public PartTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /** @return this employee's weekly pay */
    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate();
    }
}
