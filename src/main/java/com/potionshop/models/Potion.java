package com.potionshop.models;

public class Potion extends Entity {

    private String description;
    private double price;
    private int storeQuantity;
    private String type;

    public Potion(String _id, String _name, String _description, double _price, int _storeQuantity, String _type) {
        super(_id, _name);
        this.description = _description;
        this.price = _price;
        this.storeQuantity = _storeQuantity;
        this.type = _type;
    }

    public Potion() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStoreQuantity() {
        return storeQuantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStoreQuantity(int storeQuantity) {
        this.storeQuantity = storeQuantity;
    }

}
