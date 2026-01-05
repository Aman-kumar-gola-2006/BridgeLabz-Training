package com.linkedlist.doublylinkedlist.undoredofunctionalityfortexteditor;

public class TextEditor {
	 private TextState head;
	    private TextState tail;
	    private TextState current;
	    private int size;
	    private final int MAX_HISTORY = 10;

	
	    public void addState(String text) {
	        TextState newState = new TextState(text);

	        // If undo was used, clear redo history
	        if (current != null && current.next != null) {
	            current.next.prev = null;
	            current.next = null;
	            tail = current;
	            size = calculateSize();
	        }

	        if (head == null) {
	            head = tail = current = newState;
	            size = 1;
	        } else {
	            tail.next = newState;
	            newState.prev = tail;
	            tail = newState;
	            current = newState;
	            size++;
	        }

	        // Limit history size
	        if (size > MAX_HISTORY) {
	            head = head.next;
	            head.prev = null;
	            size--;
	        }
	    }

	    // UNDO 

	    public void undo() {
	        if (current != null && current.prev != null) {
	            current = current.prev;
	        } else {
	            System.out.println("Nothing to undo");
	        }
	    }

	    //REDO 

	    public void redo() {
	        if (current != null && current.next != null) {
	            current = current.next;
	        } else {
	            System.out.println("Nothing to redo");
	        }
	    }

	    // DISPLAY CURRENT 

	    public void displayCurrentState() {
	        if (current != null) {
	            System.out.println("Current Text: " + current.content);
	        } else {
	            System.out.println("Editor is empty");
	        }
	    }

	   
	    private int calculateSize() {
	        int count = 0;
	        TextState temp = head;
	        while (temp != null) {
	            count++;
	            temp = temp.next;
	        }
	        return count;
	    }
}
