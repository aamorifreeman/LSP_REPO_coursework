# Assignment 3 Design

Assignment 2 placed file handling, input validation, payroll calculation, output formatting, and summary counts in one `ETLPipeline` class. Its `transform` method performed most of the work for each row.

Assignment 3 keeps `ETLPipeline` as the entry point and coordinator for file I/O and counts. `Employee` represents a validated input row and owns CSV parsing. `PayrollCalculator` owns overtime, the IT adjustment, pay level, and employment status rules. `PayrollRecord` represents the calculated result and owns output CSV formatting. These classes separate input data, business rules, and output representation while leaving the original behavior intact. Each class has one clear responsibility, so a change to a payroll rule does not require changing file handling or CSV formatting.

I compiled both packages and ran Assignment 3 on the supplied input. It read 14 rows, transformed 7, skipped 7, and produced a CSV identical to the checked-in Assignment 2 output.

## AI and external resources

I used AI for guidance while working on this project. [AI interaction transcript](https://docs.google.com/document/d/1VYzBZi2bOBRlvzppmb4GKr01ejV6afRd_CL3qFsbJ5A/edit?usp=sharing).

No other Internet resources were used.
