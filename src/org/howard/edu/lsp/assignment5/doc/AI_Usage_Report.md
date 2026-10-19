# AI Usage Report

I used ChatGPT to ask clarifying questions and understand the assignment's scope. I also used OpenAI Codex to read the requirements, copy the supplied driver, generate IntegerSet.java and its Javadocs, run the driver and additional tests, and prepare the submission files. The recorded tests were run by Codex; I am not claiming that I independently verified the implementation.

## AI conversations

- [My ChatGPT clarification discussion — user-provided transcript](https://docs.google.com/document/d/1lCUGYgzWjkSrKHZCO_LNsJRQYk--rYTAOmEAoHyMkBk/edit?usp=sharing)
- [Assignment request and clarification conversation](codex://threads/01a108e6-8331-7702-86e5-ca60e0b300e9)
- [Implementation and testing conversation](codex://threads/01a15443-bcc7-77fe-950b-cb841718902b)

My linked Google Doc contains the ChatGPT clarification transcript; its Drive permissions were checked on October 19, 2026 and allow anyone with the link to read it. It does not document the separate Codex implementation assistance. Before submission, I still need instructor-accessible links for the two Codex conversations above. Their local links do not provide instructor access. The assignment requires links to all AI conversations and does not explicitly say whether a linked transcript can replace a direct conversation link.

The clarification transcript includes general examples in Python and a universal-set definition of complement. The submitted Java code follows the assignment-specific definition: A.complement(B) returns B minus A. Empty largest() and smallest() calls throw IllegalStateException as required.

## External websites and references used

- Assignment announcement: https://piazza.com/class/mrp5uaz0jz13oh/post/33
- Course resources: https://piazza.com/howard/fall2026/csci363540/resources
- Professor's assignment and embedded Driver.java: https://piazza.com/class_profile/get_resource/mrp5uaz0jz13oh/mv8lhef9ahg6xf
- Oracle Java SE 17 TreeSet API: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeSet.html
- Official Eclipse Temurin JDK download used for compilation and testing: https://api.adoptium.net/v3/binary/latest/17/ga/mac/aarch64/jdk/hotspot/normal/eclipse

I used the professor’s Driver.java without modifications. Codex verified the copied code against the original document.
