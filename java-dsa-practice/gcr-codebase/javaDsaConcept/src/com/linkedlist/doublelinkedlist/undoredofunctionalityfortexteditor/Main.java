package com.linkedlist.doublylinkedlist.undoredofunctionalityfortexteditor;

import java.util.*;
public class Main {

    static Scanner sc = new Scanner(System.in);
    static TextEditor editor = new TextEditor();

    public static void main(String[] args) {

        int choice;
        do {
            menu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addText();
                case 2 -> editor.undo();
                case 3 -> editor.redo();
                case 4 -> editor.displayCurrentState();
                case 0 -> System.out.println("Exiting Editor...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    static void menu() {
        System.out.println("\n--- TEXT EDITOR MENU ---");
        System.out.println("1. Add Text / Perform Action");
        System.out.println("2. Undo");
        System.out.println("3. Redo");
        System.out.println("4. Display Current Text");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    static void addText() {
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        editor.addState(text);
    }
}
