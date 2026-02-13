package collectors.studentresultgrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentGrouping {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		
		  students.add(new Student("aliya", 'A'));
	      students.add(new Student("asma", 'B'));
	      students.add(new Student("farhan", 'C'));
	      students.add(new Student("arif", 'A'));
	      students.add(new Student("neha", 'B'));
	      
	      Map<Character, List<Student>> studentByGrade = students.stream().collect(Collectors.groupingBy(Student::getGrade));
	      
	      //Print Result
	      studentByGrade.forEach((grade, studentlist)->{
	    	  System.out.println("Grade "+ grade+" :");
	    	  studentlist.forEach(s->System.out.println(" "+ s.getName()));
	      });
	}
}
