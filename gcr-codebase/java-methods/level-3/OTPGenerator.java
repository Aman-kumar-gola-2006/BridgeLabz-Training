import java.util.*;

public class OTPGenerator {

    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        System.out.println("welcome to Java World");
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {

       //creating an array to store the otps
        int otps[] = new int[10];

        // Generate OTPs 10 times
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        // Display OTPs
        System.out.println("Generated OTPs:");
        for (int i = 0; i < otps.length; i++) {
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }

        // Validate uniqueness
        if (areOTPsUnique(otps)) {
            System.out.println("All OTPs are unique");
        } else {
            System.out.println("Duplicate OTPs found");
        }
    }
}