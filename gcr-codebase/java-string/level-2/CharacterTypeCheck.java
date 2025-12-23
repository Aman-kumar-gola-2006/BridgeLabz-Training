import java.util.*;

public class CharacterTypeCheck {

    // Method to check whether character is vowel, consonant or not a letter
    public static String checkCharacter(char ch) {

        // Convert uppercase letter to lowercase using ASCII value
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        // Check if character is an alphabet
        if (ch >= 'a' && ch <= 'z') {

            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }

        } else {
            return "Not a Letter";
        }
    }

    // Method to store character and its type in 2D array
    public static String[][] findCharacterTypes(String s) {

        String[][] result = new String[s.length()][2];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacter(ch);
        }

        return result;
    }

    // Method to display result
    public static void displayResult(String[][] data) {

        System.out.println("Char\tType");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String input = sc.nextLine();

        String[][] result = findCharacterTypes(input);
        displayResult(result);
    }
}
