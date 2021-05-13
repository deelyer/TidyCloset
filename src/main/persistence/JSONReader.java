package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.TidyCloset;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JSONReader {
    private String source;

    public JSONReader(String source) {
        this.source = source;
    }

    public TidyCloset read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCloset(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private TidyCloset parseCloset(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        String gender =  jsonObject.getString("gender");
        double weight = jsonObject.getDouble("weight");
        double height = jsonObject.getDouble("height");
        Person person = new Person(name, age, gender, weight, height);
        TidyCloset closet = new TidyCloset(person);
        addClosetItems(closet, jsonObject);

        return closet;
    }

    private void addClosetItems(TidyCloset closet, JSONObject jsonObject) {
        addBottoms(closet, jsonObject);
        addTops(closet, jsonObject);
    }

    private void addBottoms(TidyCloset closet, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("bottoms");
        for (Object json : jsonArray) {
            JSONObject nextBottom = (JSONObject) json;
            addBottom(closet, nextBottom);
        }
    }

    private void addTops(TidyCloset closet, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("tops");
        for (Object json : jsonArray) {
            JSONObject nextTop = (JSONObject) json;
            addTop(closet, nextTop);
        }
    }

    private void addBottom(TidyCloset closet, JSONObject jsonObject) {
        String description = jsonObject.getString("description");
        double price = jsonObject.getDouble("price");
        BottomType type = BottomType.valueOf(jsonObject.getString("type"));
        Size size = Size.valueOf(jsonObject.getString("size"));
        Brand brand = Brand.valueOf(jsonObject.getString("brand"));
        ColourType colour = ColourType.valueOf(jsonObject.getString("colour"));
        String itemReference = jsonObject.getString("reference");
        closet.addBottom(new Bottom(description, price, type, size, brand, colour, itemReference));
    }

    private void addTop(TidyCloset closet, JSONObject jsonObject) {
        String description = jsonObject.getString("description");
        double price = jsonObject.getDouble("price");
        TopType type = TopType.valueOf(jsonObject.getString("type"));
        Size size = Size.valueOf(jsonObject.getString("size"));
        Brand brand = Brand.valueOf(jsonObject.getString("brand"));
        ColourType colour = ColourType.valueOf(jsonObject.getString("colour"));
        String itemReference = jsonObject.getString("reference");
        closet.addTop(new Top(description, price, type, size, brand, colour, itemReference));
    }
}
