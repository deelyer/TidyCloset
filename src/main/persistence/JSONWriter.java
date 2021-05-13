package persistence;

import org.json.JSONObject;
import ui.TidyCloset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JSONWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    public JSONWriter(String destination) {
        this.destination = destination;
    }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    public void write(TidyCloset closet) {
        JSONObject json = closet.toJson();
        saveToFile(json.toString(TAB));
    }

    public void close() {
        writer.close();
    }

    private void saveToFile(String json) {
        writer.print(json);
    }
}
