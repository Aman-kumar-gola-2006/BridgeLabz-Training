															
/*
Class Diagram
The class diagram represents the structure of a school results application where students have subjects, and their scores are calculated for grades.
Diagram Description:
Classes: Student, Subject, GradeCalculator
Relationships:
A Student has multiple Subject entries (Aggregation).
GradeCalculator computes the results for a Student.
→ Draw the Class Diagram

*/


														    	+----------------------+
																|        Student       |
																+----------------------+
																| - studentId : int    |
																| - name : String      |
																+----------------------+
																| + addSubject()       |
																| + getSubjects()      |
																+----------------------+
																		  ◇
																		  |
																		  | Aggregation
																		  |
																+----------------------+
																|        Subject       |
																+----------------------+
																| - subjectName:String |
																| - marks : int        |
																+----------------------+
																| + getMarks()         |
																+----------------------+

																		Association
																+----------------------+
																|   GradeCalculator    |
																+----------------------+
																|                      |
																+----------------------+
																| + calculateTotal()   |
																| + calculatePercentage|
																| + calculateGrade()   |
																+----------------------+
																			|
																			|
																			|
																		+--------+
																		|Student |
																		+--------+
