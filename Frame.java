package NoteKeeper;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static JTextArea textArea;

    public Frame() {
        // Set up the frame
        setTitle("Note Keeper");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize the text area and add it to a scroll pane
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        // Set frame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        // Launch the application
        SwingUtilities.invokeLater(() -> new Frame());
    }
}
