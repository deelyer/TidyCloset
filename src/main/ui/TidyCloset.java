package ui;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collection;

public class TidyCloset implements Writable {
    private Collection<Bottom> bottoms;
    private Collection<Top> tops;
    private Collection<Accessory> accessories;
    private Collection<Shoes> shoes;
    private Person person;

    public TidyCloset() {
        this.bottoms = new ArrayList<>();
        this.tops = new ArrayList<>();
        this.accessories = new ArrayList<>();
        this.shoes   = new ArrayList<>();
        this.person = null;
    }

    public TidyCloset(Person person) {
        this.bottoms = new ArrayList<>();
        this.tops = new ArrayList<>();
        this.accessories = new ArrayList<>();
        this.shoes   = new ArrayList<>();
        this.person = person;
    }

    // getters & setters
    public Collection<Bottom> getBottoms() {
        return bottoms;
    }

    public void setBottoms(Collection<Bottom> bottoms) {
        this.bottoms = bottoms;
    }

    public Collection<Top> getTops() {
        return tops;
    }

    public void setTops(Collection<Top> tops) {
        this.tops = tops;
    }

    public Collection<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Collection<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Collection<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(Collection<Shoes> shoes) {
        this.shoes = shoes;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void addBottom(Bottom bottom) {
        if (!this.bottoms.contains(bottom)) {
            this.bottoms.add(bottom);
        }
    }

    public void addTop(Top top) {
        if (!this.tops.contains(top)) {
            this.tops.add(top);
        }
    }

    public void addAccessory(Accessory accessory) {
        if (!this.accessories.contains(accessory)) {
            this.accessories.add(accessory);
        }
    }

    public void addShoes(Shoes shoes) {
        if (!this.shoes.contains(shoes)) {
            this.shoes.add(shoes);
        }
    }

    public void removeBottom(Bottom bottom) {
        this.bottoms.remove(bottom);
    }

    public void removeTop(Top top) {
        this.tops.remove(top);
    }

    public void removeAccessory(Accessory accessory) {
        this.accessories.remove(accessory);
    }

    public void removeShoes(Shoes shoes) {
        this.shoes.remove(shoes);
    }


    @Override
    // EFFECTS: converts closet information to JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", person.getName());
        json.put("age", person.getAge());
        json.put("gender", person.getGender());
        json.put("weight", person.getWeight());
        json.put("height", person.getHeight());
        json.put("bottoms", bottomsToJson());
        json.put("tops", topsToJson());

        return json;
    }

    private JSONArray bottomsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Bottom b : bottoms) {
            jsonArray.put(b.toJson());
        }

        return jsonArray;
    }

    private JSONArray topsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Top t : tops) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

}
