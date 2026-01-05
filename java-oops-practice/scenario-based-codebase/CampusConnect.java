import java.util.ArrayList;
import java.util.Scanner;

// ---------- Interface ----------
interface ICourseActions {
    void enrollCourse(Course course);
    void dropCourse(Course course);
}

// ---------- Base Class ----------
class Person {
    protected int id;
    protected String name;
    protected String email;
    protected String city;

    Person(int id, String name, String email, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("City: " + city);
    }
}

// ---------- Student Class ----------
class Student extends Person implements ICourseActions {
    private double grade1;
    private double grade2;
    private double grade3;
    private Course course;

    Student(int id, String name, String email, String city,
            double g1, double g2, double g3) {
        super(id, name, email, city);
        this.grade1 = g1;
        this.grade2 = g2;
        this.grade3 = g3;
    }

    // GPA calculation using operators
    public double calculateGPA() {
        return (grade1 + grade2 + grade3) / 3;
    }

    @Override
    public void enrollCourse(Course course) {
        this.course = course;
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    @Override
    public void dropCourse(Course course) {
        this.course = null;
        course.removeStudent(this);
        System.out.println(name + " dropped " + course.getCourseName());
    }

    // Polymorphism
    @Override
    public void printDetails() {
        System.out.println("\n--- Student Details ---");
        super.printDetails();
        System.out.println("GPA: " + calculateGPA());
        if (course != null) {
            System.out.println("Enrolled Course: " + course.getCourseName());
        }
    }
}

// ---------- Faculty Class ----------
class Faculty extends Person {
    private String department;

    Faculty(int id, String name, String email, String city, String dept) {
        super(id, name, email, city);
        this.department = dept;
    }

    // Polymorphism
    @Override
    public void printDetails() {
        System.out.println("\n--- Faculty Details ---");
        super.printDetails();
        System.out.println("Department: " + department);
    }
}

// ---------- Course Class ----------
class Course {
    private String courseName;
    private Faculty faculty;
    private ArrayList<Student> students;

    Course(String courseName, Faculty faculty) {
        this.courseName = courseName;
        this.faculty = faculty;
        students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void printCourseDetails() {
        System.out.println("\n=== Course Details ===");
        System.out.println("Course Name: " + courseName);
        System.out.println("Faculty: " + faculty.name);
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

// ---------- Main Class ----------
public class CampusConnect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Faculty input
        System.out.println("Enter Faculty Details:");
        Faculty faculty = new Faculty(
                101,
                "Dr. Abhay Sharma",
                "abhay@college.edu",
                "Indore",
                "Computer Science"
        );

        // Course creation
        Course javaCourse = new Course("Java Programming", faculty);

        // Student input
        System.out.println("\nEnter Student Details:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("City: ");
        String city = sc.nextLine();

        System.out.print("Enter 3 subject grades: ");
        double g1 = sc.nextDouble();
        double g2 = sc.nextDouble();
        double g3 = sc.nextDouble();

        Student student = new Student(
                1,
                name,
                email,
                city,
                g1, g2, g3
        );

        // Actions
        student.enrollCourse(javaCourse);

        // Polymorphic behavior
        student.printDetails();
        faculty.printDetails();
        javaCourse.printCourseDetails();

        sc.close();
    }
}
