package ui;

import persistence.JSONReader;
import persistence.JSONWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TidyClosetGUI {
    private static final String JSON_STORE = "./data/closet.json";

    private TidyCloset closet;
    private JSONReader jsonReader;
    private JSONWriter jsonWriter;

    public static void main(String[] args) {
        new TidyClosetGUI();
    }

    public TidyClosetGUI() {
        jsonWriter = new JSONWriter(JSON_STORE);
        jsonReader = new JSONReader(JSON_STORE);
        JFrame openFrame = new JFrame("TidyCloset");
        openFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openFrame.setSize(800,800);
        openFrame.setLocationRelativeTo(null);
        openFrame.setVisible(true);
    }

    // EFFECTS: saves closet to file
    public void saveClosetToFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(closet);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: loads closet from file
    public void loadClosetFromFile() {
        try {
            closet = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
