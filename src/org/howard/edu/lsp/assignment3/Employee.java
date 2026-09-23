package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.util.Locale;

/** A validated employee input row. */
final class Employee {
    final int id;
    final String name;
    final String department;
    final BigDecimal hours;
    final BigDecimal rate;

    private Employee(int id, String name, String department,
                     BigDecimal hours, BigDecimal rate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.hours = hours;
        this.rate = rate;
    }

    /** Returns null for an invalid row, matching Assignment 2's skip behavior. */
    static Employee fromCsv(String line) {
        if (line.trim().isEmpty()) {
            return null;
        }
        String[] fields = line.split(",", -1);
        if (fields.length != 5) {
            return null;
        }
        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].trim();
        }
        try {
            int id = Integer.parseInt(fields[0]);
            BigDecimal hours = new BigDecimal(fields[3]);
            BigDecimal rate = new BigDecimal(fields[4]);
            if (hours.signum() < 0 || rate.signum() < 0) {
                return null;
            }
            return new Employee(id, fields[1].toUpperCase(Locale.ROOT),
                    fields[2], hours, rate);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
