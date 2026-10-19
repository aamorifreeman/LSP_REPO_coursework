# Large Scale Programming

Aamori Freeman's CSCI 363 coursework for Fall 2026.

Run these commands from the repository root with a JDK installed:

```sh
javac -d out src/org/howard/edu/lsp/assignment1/HelloWorld.java src/org/howard/edu/lsp/assignment2/ETLPipeline.java src/org/howard/edu/lsp/assignment3/*.java
java -cp out org.howard.edu.lsp.assignment1.HelloWorld
java -cp out org.howard.edu.lsp.assignment2.ETLPipeline
java -cp out org.howard.edu.lsp.assignment3.ETLPipeline
```

Assignment 2 reads `data/employees.csv` and writes `data/transformed_employees.csv`.
Assignment 3 refactors the same pipeline into employee, payroll calculation, and output record classes. Run either assignment's pipeline from the repository root; both write the same output file.
Compiled files and IDE configuration are excluded from version control.

## Assignment 5 — IntegerSet

Assignment 5 implements integer sets and independent set operations. Compile and run the professor's unchanged driver from the repository root:

```sh
javac -d out src/org/howard/edu/lsp/assignment5/*.java
java -cp out org.howard.edu.lsp.assignment5.Driver
```

The complete driver output is in `src/org/howard/edu/lsp/assignment5/doc/Driver_Output.txt` (47/47 tests; 92/92 functional points). AI assistance and the supplied clarification transcript are documented in `src/org/howard/edu/lsp/assignment5/doc/AI_Usage_Report.md`. Instructor-accessible links for the separately documented Codex conversations remain to be supplied before course submission.
