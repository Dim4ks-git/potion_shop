//--------------------------------------------------
// IMPORTS
//--------------------------------------------------

package com.potionshop.models;

//--------------------------------------------------
// CLASS Potion
//--------------------------------------------------
/**
 * Represents a potion in the Potion Shop system.<br>
 * Each potion has a description, price, available quantity, and type.
 */
public class Potion extends Entity {

    //---------------------------------------
    // Fields
    //---------------------------------------
    private String description;
    private double price;
    private int storeQuantity;
    private String type;

    //---------------------------------------
    // Constructors
    //---------------------------------------

    /**
     * Default constructor for creating a Potion with default values.<br>
     * Initializes fields to default states.
     */
    public Potion() {
        super();
        this.description = "default";
        this.price = 0.0;
        this.storeQuantity = 0;
        this.type = "default";
    }

    /**
     * Parameterized constructor for creating a Potion with specified details.<br>
     * Ensures price and quantity constraints are met.
     * @param _id - The unique identifier for the potion.
     * @param _name - The name of the potion.
     * @param _description - A brief description of the potion.
     * @param _price - The price of the potion (must be positive).
     * @param _storeQuantity - The available quantity of the potion (must be non-negative).
     * @param _type - The type or category of the potion.
     */
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

    /**
     * Copy constructor for creating a new Potion as a copy of an existing one.<br>
     * @param other - The Potion object to copy.
     */
    public Potion(Potion other) {
        super(other);
        this.description = other.description;
        this.price = other.price;
        this.storeQuantity = other.storeQuantity;
        this.type = other.type;
    }

    //---------------------------------------
    // Get Methods
    //---------------------------------------

    /**
     * Retrieves the description of the potion.<br>
     * @return The description as a String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the price of the potion.<br>
     * @return The price as a double.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the available quantity of the potion.<br>
     * @return The store quantity as an integer.
     */
    public int getStoreQuantity() {
        return storeQuantity;
    }

    /**
     * Retrieves the type or category of the potion.<br>
     * @return The type as a String.
     */
    public String getType() {
        return type;
    }

    //---------------------------------------
    // Set Methods
    //---------------------------------------

    /**
     * Updates the type or category of the potion.<br>
     * @param type - The new type as a String.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Updates the description of the potion.<br>
     * @param description - The new description as a String.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Updates the price of the potion.<br>
     * @param price - The new price as a double.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Updates the available quantity of the potion.<br>
     * @param storeQuantity - The new quantity as an integer.
     */
    public void setStoreQuantity(int storeQuantity) {
        this.storeQuantity = storeQuantity;
    }

    //---------------------------------------
    // Business Methods
    //---------------------------------------

    /**
     * Increases the available quantity of the potion.<br>
     * Ensures no integer overflow occurs.
     * @param amount - The amount to increase by.
     * @return The updated store quantity.
     */
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

    /**
     * Decreases the available quantity of the potion.<br>
     * Ensures no negative quantity results.
     * @param amount - The amount to decrease by.
     * @return The updated store quantity.
     */
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

    //---------------------------------------
    // toString
    //---------------------------------------

    /**
     * Returns a string representation of the potion.<br>
     * @return A string containing potion details.
     */
    @Override
    public String toString() {
        return "Potion{" +
                "id='" + getId() + "', name='" + getName() + "', description='" + description + "', price=" + price +
                ", storeQuantity=" + storeQuantity + ", type='" + type + "'}";
    }
}
