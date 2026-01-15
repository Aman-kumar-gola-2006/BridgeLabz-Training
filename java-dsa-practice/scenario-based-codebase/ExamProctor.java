import java.util.*;

// Main Exam System
public class ExamProctor {

    Stack<Integer> navStack = new Stack<>();                 // track visited questions
    HashMap<Integer, String> studentAnswers = new HashMap<>(); // store answers
    HashMap<Integer, String> correctAnswers = new HashMap<>(); // correct answer key

    // Function: evaluate score
    public int calculateScore() {
        int score = 0;
        for (int qID : studentAnswers.keySet()) {
            String studAns = studentAnswers.get(qID);
            String corrAns = correctAnswers.get(qID);

            if (studAns.equalsIgnoreCase(corrAns)) {
                score++;
            }
        }
        return score;
    }

    // Add question visit to stack
    public void visitQuestion(int qID) {
        navStack.push(qID);
        System.out.println("Visited question: " + qID);
    }

    // Store student's answer
    public void saveAnswer(int qID, String ans) {
        studentAnswers.put(qID, ans);
        System.out.println("Saved answer for Q" + qID);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExamProctor exam = new ExamProctor();

        // Setup correct answers (for demo)
        exam.correctAnswers.put(1, "A");
        exam.correctAnswers.put(2, "C");
        exam.correctAnswers.put(3, "B");

        while (true) {
            System.out.println("\n--- ExamProctor Menu ---");
            System.out.println("1. Visit Question");
            System.out.println("2. Save Answer");
            System.out.println("3. View Navigation History");
            System.out.println("4. Submit Exam");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            if (ch == 5) break;

            switch (ch) {

                case 1:
                    System.out.print("Enter question number: ");
                    int q = sc.nextInt();
                    exam.visitQuestion(q);
                    break;

                case 2:
                    System.out.print("Enter question ID: ");
                    int qid = sc.nextInt();
                    System.out.print("Enter answer (A/B/C/D): ");
                    String ans = sc.next();
                    exam.saveAnswer(qid, ans);
                    break;

                case 3:
                    System.out.println("Navigation Stack (Last visited → First):");
                    System.out.println(exam.navStack);
                    break;

                case 4:
                    int score = exam.calculateScore();
                    System.out.println("Exam submitted.");
                    System.out.println("Your Score: " + score + " / " + exam.correctAnswers.size());
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
