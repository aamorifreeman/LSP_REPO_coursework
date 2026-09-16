package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** The calculated values and CSV representation of one output row. */
final class PayrollRecord {
    private final Employee employee;
    private final BigDecimal gross;
    private final String level;
    private final String status;

    PayrollRecord(Employee employee, BigDecimal gross, String level, String status) {
        this.employee = employee;
        this.gross = gross;
        this.level = level;
        this.status = status;
    }

    String toCsv() {
        return String.join(",", Integer.toString(employee.id), employee.name,
                employee.department, format(employee.hours), format(employee.rate),
                format(gross), level, status);
    }

    private String format(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}
