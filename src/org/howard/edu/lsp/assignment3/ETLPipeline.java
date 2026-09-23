package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/** Coordinates CSV input, employee transformation, and CSV output. */
public class ETLPipeline {
    private static final Path INPUT = Path.of("data/employees.csv");
    private static final Path OUTPUT = Path.of("data/transformed_employees.csv");
    private static final String HEADER = "EmployeeID,Name,Department,HoursWorked,"
            + "HourlyRate,GrossPay,PayLevel,EmploymentStatus";

    public static void main(String[] args) {
        int read = 0;
        int transformed = 0;
        int skipped = 0;
        PayrollCalculator calculator = new PayrollCalculator();

        try (BufferedReader reader = Files.newBufferedReader(INPUT, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(OUTPUT, StandardCharsets.UTF_8)) {
            writer.write(HEADER);
            writer.newLine();
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                read++;
                Employee employee = Employee.fromCsv(line);
                if (employee == null) {
                    skipped++;
                } else {
                    writer.write(calculator.calculate(employee).toCsv());
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
}
