package com.jsondatahandeling.iplandcensoranalyzer;

/**
 * Utility class for censoring IPL data
 */
 class CensorUtil {

    /**
     * Masks team name by keeping first word and replacing rest with ***
     * Example: "Mumbai Indians" → "Mumbai ***"
     */
    public static String maskTeam(String teamName) {

        // Safety check
        if (teamName == null || teamName.trim().isEmpty()) {
            return "***";
        }

        // Split team name by space
        String[] parts = teamName.split(" ");

        // If only one word exists
        if (parts.length == 1) {
            return parts[0] + " ***";
        }

        // Return first word + ***
        return parts[0] + " ***";
    }

    /**
     * Redacts player name completely
     */
    public static String redactPlayer() {
        return "REDACTED";
    }
}
