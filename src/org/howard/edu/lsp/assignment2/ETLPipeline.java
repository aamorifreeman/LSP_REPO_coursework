package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

/**
 * Reads employee records, calculates payroll, and writes a transformed CSV.
 * @author Aamori Freeman
 */
public class ETLPipeline {
    private static final Path INPUT = Path.of("data/employees.csv");
    private static final Path OUTPUT = Path.of("data/transformed_employees.csv");
    private static final String HEADER = "EmployeeID,Name,Department,HoursWorked,"
            + "HourlyRate,GrossPay,PayLevel,EmploymentStatus";

    public static void main(String[] args) {
        int read = 0;
        int transformed = 0;
        int skipped = 0;

        try (BufferedReader reader = Files.newBufferedReader(INPUT, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(OUTPUT, StandardCharsets.UTF_8)) {
            writer.write(HEADER);
            writer.newLine();
            reader.readLine(); // The first line is the input header.
            String line;
            while ((line = reader.readLine()) != null) {
                read++;
                String result = transform(line);
                if (result == null) {
                    skipped++;
                } else {
                    writer.write(result);
                    writer.newLine();
                    transformed++;
                }
            }
        } catch (IOException e) {
            System.err.println("Unable to process payroll: " + e.getMessage());
            return;
        }

        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + transformed);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output file: " + OUTPUT);
    }

    /** Returns the output row, or null when the input row is invalid. */
    private static String transform(String line) {
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
        fields[1] = fields[1].toUpperCase(Locale.ROOT);

        int id;
        BigDecimal hours;
        BigDecimal rate;
        try {
            id = Integer.parseInt(fields[0]);
            hours = new BigDecimal(fields[3]);
            rate = new BigDecimal(fields[4]);
        } catch (NumberFormatException e) {
            return null;
        }
        if (hours.signum() < 0 || rate.signum() < 0) {
            return null;
        }

        BigDecimal regularHours = new BigDecimal("40");
        BigDecimal gross = hours.min(regularHours).multiply(rate);
        if (hours.compareTo(regularHours) > 0) {
            BigDecimal overtime = hours.subtract(regularHours)
                    .multiply(rate).multiply(new BigDecimal("1.5"));
            gross = gross.add(overtime);
        }
        if (fields[2].equals("IT")) {
            gross = gross.multiply(new BigDecimal("1.05"));
        }
        gross = gross.setScale(2, RoundingMode.HALF_UP);
        String level = payLevel(gross);
        String status = hours.compareTo(new BigDecimal("30")) < 0
                ? "Part-Time" : "Full-Time";

        return String.join(",", Integer.toString(id), fields[1], fields[2],
                format(hours), format(rate), format(gross), level, status);
    }

    private static String payLevel(BigDecimal gross) {
        if (gross.compareTo(new BigDecimal("500")) < 0) {
            return "Low";
        }
        if (gross.compareTo(new BigDecimal("1000")) < 0) {
            return "Standard";
        }
        if (gross.compareTo(new BigDecimal("2000")) < 0) {
            return "High";
        }
        return "Executive";
    }

    private static String format(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}
