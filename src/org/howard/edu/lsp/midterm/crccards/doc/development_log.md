# Development log

## Work and assistance

Codex generated Book.java, Library.java, Javadoc, the CRC explanation, and this disclosure. It extracted the provided driver, compiled the implementation with JDK 17, and ran all 44 driver checks successfully. HashMap indexes books by ISBN; list methods create separate lists; the borrowed count is derived from current book states so failed operations cannot desynchronize a cached count.

## Resources

- Instructor-provided Practice Mid-term document, supplied locally at `/Users/aamorifreeman/Downloads/Practice Mid-term`: source of all question requirements, signatures, rubrics, and instructor drivers. Word line separators were normalized to Java source newlines; driver statements were preserved.
- OpenAI Codex in this chat, October 26, 2026: generated the solution and supporting documents, explained requirements, and performed local verification. The full visible prompts and responses through delivery are included in [shared AI conversation transcript](../../ai_conversation.md). Generated source and written answers are in this submission; internal tool execution is not represented as personal work by the student.
- No external websites, lecture notes, or offline books were used to implement this question. Java APIs were used from model knowledge and verified with the installed JDK.

## Verification and submission state

Java build products were written outside the deliverable directory. No commits or pushes were performed. Question 4 and ai_reflection.md were not created or edited. Append any later assistance to the transcript before submitting.
