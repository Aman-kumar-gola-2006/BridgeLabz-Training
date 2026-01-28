package com.mapinterface.votingsystem;

public class Main {

	public static void main(String[] args) {

        VotingSystem system = new VotingSystem();

        // Cast votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Carol");
        system.castVote("Bob");

        // Display results
        system.displayVoteOrder();
        system.displayVoteCount();
        system.displaySortedResults();
    }
}
