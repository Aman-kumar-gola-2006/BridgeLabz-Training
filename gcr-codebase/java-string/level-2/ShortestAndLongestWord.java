import java.util.*;

public class ShortestAndLongestWord {

    // Method to split text into words using charAt()
    public static String[] splitWords(String text) {

        ArrayList<String> words = new ArrayList<>();
        String word = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.equals("")) {
                    words.add(word);
                    word = "";
                }
            }
        }

        // add last word
        if (!word.equals("")) {
            words.add(word);
        }

        return words.toArray(new String[0]);
    }

    // Method to find string length WITHOUT using length()
    public static int findLength(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            count++;
        }
        return count;
    }

    // Method to return 2D array of word and its length
    public static String[][] wordWithLength(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Method to find shortest and longest word
    public static int[] findShortestAndLongest(String[][] data) {

        int shortest = Integer.parseInt(data[0][1]);
        int longest = Integer.parseInt(data[0][1]);

        for (int i = 1; i < data.length; i++) {
            int len = Integer.parseInt(data[i][1]);

            if (len < shortest)
                shortest = len;

            if (len > longest)
                longest = len;
        }

        return new int[]{shortest, longest};
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text:");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] wordLength = wordWithLength(words);
        int[] result = findShortestAndLong+est(wordLength);

        System.out.println("\nWords and their lengths:");
        for (int i = 0; i < wordLength.length; i++) {
            System.out.println(wordLength[i][0] + " -> " + wordLength[i][1]);
        }

        System.out.println("\nShortest word length: " + result[0]);
        System.out.println("Longest word length: " + result[1]);
    }
}
