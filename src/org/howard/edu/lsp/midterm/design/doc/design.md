# Proposed CRC cards

Class: Student
Responsibilities: Encapsulate validated student ID, name, email address, and optional phone number; expose contact information through a public interface.
Collaborators: None.

Class: Course
Responsibilities: Encapsulate course code and nonnegative course credit hours.
Collaborators: None.

Class: Registration
Responsibilities: Represent a student's registration for a course, the assessed tuition, and the credit hours used to calculate it; retain a consistent record for persistence and confirmation.
Collaborators: Student, Course.

Class: TuitionCalculator
Responsibilities: Own the per-credit rate and heavy-load discount policy; calculate tuition using the supplied creditHours value, preserving the provided behavior: charge creditHours times 750.0 and apply a 10 percent discount when that same value is at least 12. Keep policy constants together and validate nonnegative credit hours.
Collaborators: Course.

Class: RegistrationService
Responsibilities: Coordinate validation, tuition calculation, Registration creation, saving, confirmation, and audit logging; stop success processing if saving fails; distinguish a saved registration with failed notification from a failed save. Delegate the details of each task.
Collaborators: Student, Course, Registration, TuitionCalculator, RegistrationRepository, ConfirmationSender, AuditLogger.

Class: RegistrationRepository (interface)
Responsibilities: Define the operation for durably saving a Registration and reporting storage failure without exposing a storage format to callers.
Collaborators: Registration.

Class: FileRegistrationRepository
Responsibilities: Implement RegistrationRepository using an explicitly configured local file; serialize records safely, close resources reliably, and report write failures.
Collaborators: Registration.

Class: ConfirmationSender (interface)
Responsibilities: Define confirmation delivery for a saved Registration and report delivery failure.
Collaborators: Registration.

Class: EmailConfirmationSender
Responsibilities: Implement ConfirmationSender by formatting and sending an email using the student's email address; report unsuccessful delivery.
Collaborators: Registration, Student.

Class: AuditLogger
Responsibilities: Record registration outcomes with timestamps, including storage and confirmation failures; keep audit output separate from confirmation delivery.
Collaborators: Registration.

Class: ApplicationConfiguration
Responsibilities: Read deployment settings; construct and connect the registration service and concrete collaborators; supply storage location, delivery configuration, and tuition policy values at startup.
Collaborators: RegistrationService, TuitionCalculator, FileRegistrationRepository, EmailConfirmationSender, AuditLogger.

The initial implementation uses file storage and email. RegistrationService already depends on the storage and confirmation interfaces, so later implementations can be selected without changing registration or tuition behavior. All state is private and accessed through each class's public interface. These cards describe a proposed design only; Question 2 does not require Java implementation.
