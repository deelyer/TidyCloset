package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

public class Bottom implements Writable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bottom)) return false;
        Bottom bottom = (Bottom) o;
        return Double.compare(bottom.price, price) == 0 &&
                Objects.equals(description, bottom.description) &&
                type == bottom.type &&
                size == bottom.size &&
                brand == bottom.brand &&
                colour == bottom.colour &&
                Objects.equals(itemReference, bottom.itemReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, type, size, brand, colour, itemReference);
    }
}
