import java.util.Stack;

class TextEditor {
    private String text = "";
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    // Insert operation
    public void insert(String newText) {
        undoStack.push(text); // Save current state
        text = text + newText;
        redoStack.clear(); // Clear redo history
    }

    // Delete last n characters
    public void delete(int count) {
        if (count > text.length()) count = text.length();

        undoStack.push(text); // Save current state
        text = text.substring(0, text.length() - count);
        redoStack.clear(); // Clear redo history
    }

    // Undo operation
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text); // Move current to redo
            text = undoStack.pop(); // Restore previous state
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Redo operation
    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text); // Save current to undo
            text = redoStack.pop(); // Reapply last undone change
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    // Get current text
    public String getText() {
        return text;
    }

    // Driver code to test
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.insert("Hello");
        System.out.println(editor.getText());  // Hello

        editor.insert(" World");
        System.out.println(editor.getText());  // Hello World

        editor.delete(5);
        System.out.println(editor.getText());  // Hello

        editor.undo();
        System.out.println(editor.getText());  // Hello World

        editor.redo();
        System.out.println(editor.getText());  // Hello
    }
}
