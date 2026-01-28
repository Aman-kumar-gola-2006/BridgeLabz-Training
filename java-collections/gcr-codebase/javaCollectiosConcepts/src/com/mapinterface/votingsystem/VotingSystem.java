package com.mapinterface.votingsystem;

import java.util.*;

public class VotingSystem {

    // HashMap to store total votes for each candidate
    Map<String, Integer> voteCount = new HashMap<>();

    // LinkedHashMap to store vote order
    Map<Integer, String> voteOrder = new LinkedHashMap<>();

    private int voteNumber = 1;

    // Cast a vote
    public void castVote(String candidate) {

        // Store vote order
        voteOrder.put(voteNumber++, candidate);

        // Update vote count
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
    }

    // Display vote count (HashMap)
    public void displayVoteCount() {
        System.out.println("Vote Count (HashMap): " + voteCount);
    }

    // Display vote order (LinkedHashMap)
    public void displayVoteOrder() {
        System.out.println("Vote Order (LinkedHashMap): " + voteOrder);
    }

    // Display sorted results (TreeMap)
    public void displaySortedResults() {

        // TreeMap sorts candidates alphabetically
        Map<String, Integer> sortedResults = new TreeMap<>(voteCount);
        System.out.println("Sorted Results (TreeMap): " + sortedResults);
    }
}