package NoteKeeper;

import java.awt.FileDialog;
import java.io.*;

public class FileMenu {
    private static String fileName;
    private static String filePath;

    public static void newFile() {
        Frame.textArea.setText("");
        Frame.frame.setTitle("New Note - NoteKeeper");
    }

    public static void openFile() {
        FileDialog fileDialog = new FileDialog(Frame.frame, "Open Note", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            filePath = fileDialog.getDirectory() + fileName;
            Frame.frame.setTitle(fileName);

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                Frame.textArea.setText("");
                while ((line = reader.readLine()) != null) {
                    Frame.textArea.append(line + "\n");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(Frame.frame, "Unable to open file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(Frame.textArea.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(Frame.frame, "Unable to save file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void saveAs() {
        FileDialog fileDialog = new FileDialog(Frame.frame, "Save Note As", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            filePath = fileDialog.getDirectory() + fileName;
            Frame.frame.setTitle(fileName);

            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(Frame.textArea.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(Frame.frame, "Unable to save file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
