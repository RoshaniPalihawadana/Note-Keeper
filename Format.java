package NoteKeeper;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JColorChooser;

public class Format {

    public static void bold() {
        Font currentFont = Frame.textArea.getFont();
        Font boldFont = currentFont.deriveFont(Font.BOLD);
        Frame.textArea.setFont(boldFont);
    }

    public static void italic() {
        Font currentFont = Frame.textArea.getFont();
        Font italicFont = currentFont.deriveFont(Font.ITALIC);
        Frame.textArea.setFont(italicFont);
    }

    public static void fontColor() {
        Color selectedColor = JColorChooser.showDialog(null, "Select Font Color", Color.BLACK);
        if (selectedColor != null) {
            Frame.textArea.setForeground(selectedColor);
        }
    }
}
