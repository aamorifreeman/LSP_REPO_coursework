# Evolving requirements and responsibility ownership

The Part 2 design already separates registration coordination from storage and confirmation through RegistrationRepository and ConfirmationSender. To support the new requirements, add the following CRC cards:

Class: DatabaseRegistrationRepository
Responsibilities: Implement RegistrationRepository by mapping a Registration to database records, saving within an appropriate transaction, managing database resources, and reporting storage failures.
Collaborators: Registration.

Class: TextMessageConfirmationSender
Responsibilities: Implement ConfirmationSender by formatting and delivering a text message using the student's phone number; validate that a usable phone contact exists and report delivery failures.
Collaborators: Registration, Student.

Update ApplicationConfiguration's responsibilities to choose FileRegistrationRepository or DatabaseRegistrationRepository from deployment settings and to choose EmailConfirmationSender or TextMessageConfirmationSender. Its collaborators now include those two new concrete classes. The existing repository and sender interface cards, RegistrationService card, and tuition behavior remain consistent with Part 2. Student already permits an optional phone number; selecting text delivery requires that number before saving a registration intended for that channel.

ApplicationConfiguration injects the selected repository and sender into RegistrationService at startup. The service calls their public operations without branching on file versus database or email versus text. An unsupported configuration should fail during startup. Storage implementations own resource cleanup and translate infrastructure errors into the repository's documented failure contract. The service avoids sending a success confirmation after a failed save; if saving succeeds but delivery fails, it records the saved registration and reports the delivery problem separately.

An important ownership decision is placing tuition calculation in TuitionCalculator. The credit rate and discount threshold are university pricing policies, not storage or communication rules. Keeping them together allows a policy change to affect tuition calculation without editing database access, message delivery, or the workflow coordinator. Conversely, environment-specific implementation selection belongs to ApplicationConfiguration because it knows deployment settings; RegistrationService knows the registration workflow.
