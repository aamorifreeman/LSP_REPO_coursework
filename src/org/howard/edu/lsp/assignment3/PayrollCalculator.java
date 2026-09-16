package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Applies the payroll rules to a validated employee. */
final class PayrollCalculator {
    private static final BigDecimal REGULAR_HOURS = new BigDecimal("40");
    private static final BigDecimal FULL_TIME_HOURS = new BigDecimal("30");
    private static final BigDecimal OVERTIME_MULTIPLIER = new BigDecimal("1.5");
    private static final BigDecimal IT_MULTIPLIER = new BigDecimal("1.05");

    PayrollRecord calculate(Employee employee) {
        BigDecimal gross = employee.hours.min(REGULAR_HOURS).multiply(employee.rate);
        if (employee.hours.compareTo(REGULAR_HOURS) > 0) {
            BigDecimal overtime = employee.hours.subtract(REGULAR_HOURS)
                    .multiply(employee.rate).multiply(OVERTIME_MULTIPLIER);
            gross = gross.add(overtime);
        }
        if (employee.department.equals("IT")) {
            gross = gross.multiply(IT_MULTIPLIER);
        }
        gross = gross.setScale(2, RoundingMode.HALF_UP);
        String status = employee.hours.compareTo(FULL_TIME_HOURS) < 0
                ? "Part-Time" : "Full-Time";
        return new PayrollRecord(employee, gross, payLevel(gross), status);
    }

    private String payLevel(BigDecimal gross) {
        if (gross.compareTo(new BigDecimal("500")) < 0) return "Low";
        if (gross.compareTo(new BigDecimal("1000")) < 0) return "Standard";
        if (gross.compareTo(new BigDecimal("2000")) < 0) return "High";
        return "Executive";
    }
}
