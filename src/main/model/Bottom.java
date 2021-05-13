package model;

import org.json.JSONObject;
import persistence.Writable;

public class Bottom implements Writable {
    public enum BottomType {
        SPORT_SHORTS, SHORTS, JEANS, PANTS, SWEATS
    }

    private String description;
    private double price;
    private BottomType type;
    private Size size;
    private Brand brand;
    private ColourType colour;
    private String itemReference;

    public Bottom() {
        this.description = null;
        this.price = 0.00;
        this.type = null;
        this.size = null;
        this.brand = null;
        this.colour = null;
        this.itemReference = null;
    }

    public Bottom(String desc, BottomType type, Size size, Brand brand, ColourType colour, String ref) {
        this.description = desc;
        this.price = 0.00;
        this.type = type;
        this.size = size;
        this.brand = brand;
        this.colour = colour;
        this.itemReference = ref;
    }

    public Bottom(String desc, double price, BottomType type, Size size, Brand brand, ColourType colour, String ref) {
        this.description = desc;
        this.price = price;
        this.type = type;
        this.size = size;
        this.brand = brand;
        this.colour = colour;
        this.itemReference = ref;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("description", description);
        json.put("price", price);
        json.put("type", type);
        json.put("size", size);
        json.put("brand", brand);
        json.put("colour", colour);
        json.put("reference", itemReference);
        return json;
    }


}
