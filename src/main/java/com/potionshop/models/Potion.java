package com.potionshop.models;

//--------------------------------------------------
//
// CLASS Potion
//
//--------------------------------------------------

public class Potion extends Entity {

    private String description;
    private double price;
    private int storeQuantity;
    private String type;

    public Potion(String _id, String _name, String _description, double _price, int _storeQuantity, String _type) {
        super(_id, _name);
        if (_price <= 0 || _storeQuantity < 0) {
            throw new IllegalArgumentException(
                    """
                    Invalid parameter inserted, please follow next instructions:
                    - storeQuantity must be a positive integer
                    - price must be a positive double
                    """);
        }
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


    public int increaseQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }

        // Check for integer overflow
        if ((long) storeQuantity + amount > Integer.MAX_VALUE) {
            throw new ArithmeticException("Resulting quantity exceeds maximum integer value");
        } else {
            storeQuantity += amount;
        }
        return storeQuantity;
    }

    public int decreaseQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }
        if (storeQuantity - amount < 0) {
            throw new ArithmeticException("quantity cannot be negative after subtraction");
        }
        storeQuantity -= amount;
        return storeQuantity;
    }


}
