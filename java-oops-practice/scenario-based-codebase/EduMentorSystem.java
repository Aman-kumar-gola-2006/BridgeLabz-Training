// EduMentor – Personalized Learning Platform
// Simple fresher-level Java program using OOP concepts only

import java.util.*;

// ---------------- INTERFACE ----------------
// Interface for certificate generation
interface ICertifiable {
    void generateCertificate();
}

// ---------------- BASE CLASS ----------------
// User base class
class User {
    protected String name;
    protected String email;
    protected int userId;

    // Constructor
    User(String name, String email, int userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }
}

// ---------------- CHILD CLASS ----------------
// Learner class inheriting User
class Learner extends User implements ICertifiable {
    private boolean isShortCourse; // true = short course, false = full-time

    Learner(String name, String email, int userId, boolean isShortCourse) {
        super(name, email, userId);
        this.isShortCourse = isShortCourse;
    }

    // Polymorphism: certificate logic differs
    public void generateCertificate() {
        if (isShortCourse) {
            System.out.println("Certificate Generated: Short Course Completion");
        } else {
            System.out.println("Certificate Generated: Full-Time Course Completion");
        }
    }
}

// ---------------- CHILD CLASS ----------------
// Instructor class inheriting User
class Instructor extends User {

    Instructor(String name, String email, int userId) {
        super(name, email, userId);
    }

    public void displayInstructor() {
        System.out.println("Instructor Name: " + name);
    }
}

// ---------------- QUIZ CLASS ----------------
class Quiz {
    // Internal question bank must be private
    private String[] questions;

    // Answers must not be modified once set
    private final int[] answers;

    private int score;

    // Constructor with difficulty level
    Quiz(String difficulty) {

        // Logic based on difficulty
        if (difficulty.equalsIgnoreCase("easy")) {
            questions = new String[]{
                "2 + 2 = ?",
                "5 - 3 = ?"
            };
            answers = new int[]{4, 2};
        } else {
            questions = new String[]{
                "10 * 2 = ?",
                "20 / 5 = ?"
            };
            answers = new int[]{20, 4};
        }
    }

    // Method to attempt quiz
    public void attemptQuiz() {
        Scanner sc = new Scanner(System.in);
        score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            int userAnswer = sc.nextInt();

            // Operator usage for scoring
            if (userAnswer == answers[i]) {
                score = score + 1;
            }
        }
    }

    // Calculate percentage
    public double calculatePercentage() {
        return (score * 100.0) / questions.length;
    }

    public void displayResult() {
        System.out.println("Score: " + score);
        System.out.println("Percentage: " + calculatePercentage() + "%");
    }
}

// ---------------- MAIN CLASS ----------------
public class EduMentorSystem {
    public static void main(String[] args) {

        // Creating learner object
        Learner learner = new Learner(
                "Aman",
                "aman@gmail.com",
                101,
                true // short course
        );

        // Creating instructor object
        Instructor instructor = new Instructor(
                "Rahul Sir",
                "rahul@edumentor.com",
                201
        );

        instructor.displayInstructor();

        // Creating quiz with difficulty
        Quiz quiz = new Quiz("easy");

        // Quiz attempt
        quiz.attemptQuiz();

        // Display result
        quiz.displayResult();

        // Certificate generation (polymorphism)
        learner.generateCertificate();
    }
}
