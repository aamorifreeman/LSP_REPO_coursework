# AI Interaction Transcript for Assignment 3

This record contains the assignment request and the substantive interaction with Codex during the refactor. The student's name and repository are shown in the project files.

**User:** “Hi, can you complete this assignment for me? You did the second part of this assignment a little while ago, but you're adding to the same GitHub repo.” The user attached `Assignment_3_Object-Oriented_Refactoring`.

**Codex:** “I’ll read the assignment and inspect the existing repository, then implement the new requirements and run the relevant checks.”

**Codex:** “The attachment is a Word document. I’m extracting its requirements and locating the repository used for the earlier assignment part.”

**Codex:** Read the assignment document. It required preserving Assignment 2 behavior, putting Java sources in the `assignment3` package, retaining `ETLPipeline.main`, adding `doc/DESIGN.md`, and documenting AI use. Codex found the prior `LSP_REPO_coursework` repository and reviewed Assignment 2's `ETLPipeline.java`, input CSV, and expected output CSV.

**Codex:** “I found the earlier Assignment 2 repository and its ETL program. I’m refactoring that implementation in place so the new package preserves the same CSV formatting, row counts, and payroll rules.”

**Codex:** Added `Employee.java` for row parsing and validation, `PayrollCalculator.java` for the payroll rules, `PayrollRecord.java` for output representation, and `ETLPipeline.java` as the program entry point and file I/O coordinator. Updated the repository README and wrote the design comparison.

**Codex:** “The refactor is written. I’m checking that it compiles and produces the same output as Assignment 2, then I’ll add the required design discussion and AI transcript link.”

**Codex:** Compiled both assignment packages and ran Assignment 3. Console output was:

```text
Rows read: 14
Rows transformed: 7
Rows skipped: 7
Output file: data/transformed_employees.csv
```

**Codex:** Confirmed the generated output CSV had no difference from the checked-in Assignment 2 output.

**Codex:** “The new pipeline compiles and matches the checked-in Assignment 2 CSV byte for byte. The app declined a public share link for this chat, so I’m adding a repository transcript of the assignment interaction and linking it from `DESIGN.md`. ”
