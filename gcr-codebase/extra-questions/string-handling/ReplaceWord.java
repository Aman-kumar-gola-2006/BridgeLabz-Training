import java.util.*;

public class ReplaceWord {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sentence:");
        String s = sc.nextLine();

        System.out.println("Enter the word to replace:");
        String oldWord = sc.next();

        System.out.println("Enter the new word:");
        String newWord = sc.next();

        replaceWord(s, oldWord, newWord);
        sc.close();
    }

    public static void replaceWord(String s, String oldWord, String newWord) {

        String words[] = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                words[i] = newWord;
            }
        }

        // Display result
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}