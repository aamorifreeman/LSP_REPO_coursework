# Evaluation of CourseRegistration

CourseRegistration combines student and course data, tuition policy, console presentation, file persistence, notification, and logging in one operation. The concerns have different reasons to change, making the class difficult to test and extend independently.

## Encapsulation and abstraction

The public fields allow callers to change IDs, contact details, and credit hours without validation. Registration could therefore use a negative credit count or mismatched student information. Riel's heuristic 2.1 calls for hiding class data. Private state and validated construction would give each object control over its own consistency.

Riel's heuristic 2.8 recommends one key abstraction per class. Here, a change to tuition, file layout, or confirmation delivery all requires editing CourseRegistration. Separate student, course, and registration objects would clarify what each record represents and which data belongs together.

## Distribution of responsibilities

Riel's heuristics 3.1 and 3.2 favor distributing intelligence and avoiding god classes. registerStudent centralizes the workflow and the implementation of nearly every step. A registration coordinator can retain the sequence while delegating tuition, storage, notification, and audit work to collaborators. Riel's heuristic 2.9 also favors keeping related data and behavior together: tuition rates and discount rules belong with tuition calculation rather than file-writing code.

## Coupling and extension

The hard-coded file name, FileWriter construction, console output, and email assumption tie registration to particular infrastructure. Database storage or text confirmations would require changes inside the registration method. Depending on small storage and notification interfaces would let deployment configuration select implementations and would allow isolated tests using substitutes.

## Correctness and failure handling

The tuition constants 750.0, 12, and 0.90 are embedded in the workflow. The meaning of creditHours is unclear: if it represents only this course, the heavy-load discount may not reflect the student's total enrollment. The redesign preserves the supplied calculation using the same creditHours value for the charge and discount threshold. Whether that value should instead represent total enrollment is a business question to clarify before changing the rule.

The broad catch prints a stack trace and then continues to announce a confirmation and successful processing even if persistence failed. A storage failure should propagate to the coordinator so it can report failure and avoid a success confirmation. A notification failure after a successful save should be reported as a saved registration with failed delivery, rather than pretending the save failed. File closure should use try-with-resources, and durable records should use an explicit structured format rather than unescaped concatenation. The current email step only prints a message; it does not actually send email.

## References

Arthur J. Riel, Object-Oriented Design Heuristics, Addison-Wesley, 1996, chapters 2 and 3. Online book previews: https://www.oreilly.com/library/view/object-oriented-design-heuristics/020163385X/ch02.html and https://www.oreilly.com/library/view/object-oriented-design-heuristics/020163385X/ch03.html . These are general Riel references; course-specific lecture materials were not supplied and have not been claimed as consulted.
