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
