package designpatterns.behavioral;

import java.util.Stack;

public class MementoDesignPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextHistory history = new TextHistory();

        // Type and save text
        editor.setText("First text");
        history.save(editor);
        System.out.println("Current text: " + editor.getText());

        // Type and save more text
        editor.setText("Second text");
        history.save(editor);
        System.out.println("Current text: " + editor.getText());

        editor.setText("Third text");
        System.out.println("Current text: " + editor.getText());

        // Undo
        history.restore(editor);
        System.out.println("Current text: " + editor.getText()); // Output: Current text: Second line
    }
}



// Originator
class TextEditor {
    private String text;

    void setText(String text) {
        this.text = text;
    }

    String getText() {
        return text;
    }
}

// Memento
class TextMemento {
    private final String state;

    TextMemento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}

// Caretaker
class TextHistory {
    private final Stack<TextMemento> history = new Stack<>();

    void save(TextEditor editor) {
        history.push(new TextMemento(editor.getText()));
    }

    public void restore(TextEditor editor) {
        if (!history.isEmpty()) {
            System.out.println("Restoring text");
            TextMemento memonto = history.pop();
            editor.setText(memonto.getState());
        }
        else {
            System.out.println("Nothing to restore");
        }
    }
}

