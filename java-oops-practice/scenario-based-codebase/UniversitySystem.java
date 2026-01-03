// Interface for Grading
interface Graded {
    void assignGrade(double marks);
}

// ---------------- Student Class ----------------
class Student {
    private String name;
    private int rollNo;
    private double gpa;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public double getGPA() {
        return gpa;
    }

    public void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("GPA: " + gpa);
    }
}

// ---------------- Undergraduate ----------------
class Undergraduate extends Student implements Graded {

    Undergraduate(String name, int rollNo) {
        super(name, rollNo);
    }

    // Letter grading
    public void assignGrade(double marks) {
        if (marks >= 80)
            setGPA(4.0);
        else if (marks >= 60)
            setGPA(3.0);
        else
            setGPA(2.0);
    }
}

// ---------------- Postgraduate ----------------
class Postgraduate extends Student implements Graded {

    Postgraduate(String name, int rollNo) {
        super(name, rollNo);
    }

    // Pass / Fail grading
    public void assignGrade(double marks) {
        if (marks >= 50)
            setGPA(4.0);
        else
            setGPA(0.0);
    }
}

// ---------------- Course ----------------
class Course {
    String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    void displayCourse() {
        System.out.println("Course: " + courseName);
    }
}

// ---------------- Faculty ----------------
class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void assignGrade(Graded g, double marks) {
        g.assignGrade(marks);
    }
}

// ---------------- Main Class ----------------
public class UniversitySystem {

    public static void main(String[] args) {

        // Course
        Course c1 = new Course("Java Programming");

        // Faculty
        Faculty f1 = new Faculty("Dr. Sharma");

        // Students
        Undergraduate s1 = new Undergraduate("Aman", 101);
        Postgraduate s2 = new Postgraduate("Rohit", 201);

        // Assign grades
        f1.assignGrade(s1, 78);
        f1.assignGrade(s2, 45);

        // Display Data
        System.out.println("----- COURSE DETAILS -----");
        c1.displayCourse();

        System.out.println("\n----- UNDERGRADUATE STUDENT -----");
        s1.displayStudent();

        System.out.println("\n----- POSTGRADUATE STUDENT -----");
        s2.displayStudent();
    }
}
