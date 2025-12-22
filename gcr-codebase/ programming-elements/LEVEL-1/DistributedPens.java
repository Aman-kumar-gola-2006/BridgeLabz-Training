public class DistributedPens {
	public static void main(String [] args){
		int total_pens = 14;
		int students = 3;

		int pensPerStudents = total_pens/students;
		int remainingPens = total_pens % students;

		System.out.println ( "The Pen Per student is " + pensPerStudents + ". and the remaining pen not distributed is " + remainingPens + " . ");
	}
}