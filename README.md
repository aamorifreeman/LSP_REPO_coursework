# Large Scale Programming

Aamori Freeman's CSCI 363 coursework for Fall 2026.

Run these commands from the repository root with a JDK installed:

```sh
javac -d out src/org/howard/edu/lsp/assignment1/HelloWorld.java src/org/howard/edu/lsp/assignment2/ETLPipeline.java
java -cp out org.howard.edu.lsp.assignment1.HelloWorld
java -cp out org.howard.edu.lsp.assignment2.ETLPipeline
```

Assignment 2 reads `data/employees.csv` and writes `data/transformed_employees.csv`.
Compiled files and IDE configuration are excluded from version control.
