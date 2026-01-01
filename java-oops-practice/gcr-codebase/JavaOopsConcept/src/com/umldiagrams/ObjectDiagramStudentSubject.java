												
/*
Object Diagram
An object diagram provides a snapshot of the Student and their Subject objects at a particular point.
Example:
Student: John
Subjects: Maths, Science
Marks: 90, 85
→ Draw the Object Diagram

*/


												    +----------------------+
													| student1 : Student   |
													+----------------------+
													| name = "John"        |
													+----------------------+
															  |
															  | has
															  |
													   ---------------------
													   |                   |
													+-------------------+  +---------------------+
													| subject1 :Subject |  | subject2 :Subject   |
													+-------------------+  +---------------------+
													| subjectName="Maths"| | subjectName="Science"|
													| marks = 90        |  | marks = 85          |
													+-------------------+  +---------------------+
