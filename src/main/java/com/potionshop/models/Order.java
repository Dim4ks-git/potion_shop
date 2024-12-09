package com.potionshop.models;

public class Order extends Entity {
    private String timestamp;
    private Customer customer;
    private Potion potion;

    public Order(String _id, String _name, String _timestamp, Customer _customer, Potion _potion) {
        super(_id, _name);
        this.timestamp = _timestamp;
        this.customer = _customer;
        this.potion = _potion;
    }

    public Order() {
        super();
        this.timestamp = "0000-00-00T00:00:00Z";
        this.customer = null;
        this.potion = null;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}
