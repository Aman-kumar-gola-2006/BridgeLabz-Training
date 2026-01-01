/*
Sequence Diagram
The sequence diagram shows how objects interact to calculate grades.
Scenario: A student requests their grade based on marks in subjects.
Actors:
Student
GradeCalculator

*/
														
														
														
														
														
														
														
														
														
														
														Student                GradeCalculator
														   |                          |
														   |  requestGrade()          |
														   |------------------------->|
														   |                          |
														   |     calculateTotal()     |
														   |<------------------------>|
														   |                          |
														   |  calculatePercentage()   |
														   |<------------------------>|
														   |                          |
														   |    calculateGrade()      |
														   |<------------------------>|
														   |                          |
														   |  returnGrade(Grade)      |
														   |<-------------------------|
