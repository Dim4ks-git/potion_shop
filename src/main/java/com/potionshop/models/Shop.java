//--------------------------------------------------
// IMPORTS
//--------------------------------------------------

package com.potionshop.models;

import java.util.Arrays;

//--------------------------------------------------
// CLASS Shop
//--------------------------------------------------
/**
 * Represents a shop in the Potion Shop system.<br>
 * Each shop has a unique id, an address, and an inventory of potions.
 */
public class Shop extends Entity {

    //---------------------------------------
    // Fields
    //---------------------------------------
    private String address;
    private Potion[] stock;

    //---------------------------------------
    // Constructors
    //---------------------------------------

    /**
     * Default constructor for creating a Shop with default values.<br>
     * Initializes the address and stock to default states.
     */
    public Shop() {
        super();
        this.address = "default address";
        this.stock = new Potion[0];
    }

    /**
     * Parameterized constructor for creating a Shop with specified details.<br>
     * @param _id - The unique identifier for the shop.
     * @param _name - The name of the shop.
     * @param _address - The physical address of the shop.
     * @param _stock - The inventory of potions available in the shop.
     */
    public Shop(String _id, String _name, String _address, Potion[] _stock) {
        super(_id, _name);
        this.address = _address;
        this.stock = _stock;
    }

    /**
     * Copy constructor for creating a new Shop as a copy of an existing one.<br>
     * @param other - The Shop object to copy.
     */
    public Shop(Shop other) {
        super(other);
        this.address = other.address;
        this.stock = Arrays.copyOf(other.stock, other.stock.length);
    }

    //---------------------------------------
    // Get Methods
    //---------------------------------------

    /**
     * Retrieves the address of the shop.<br>
     * @return The address as a String.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retrieves the stock of potions in the shop.<br>
     * @return An array of Potion objects.
     */
    public Potion[] getStock() {
        return stock;
    }

    //---------------------------------------
    // Set Methods
    //---------------------------------------

    /**
     * Updates the address of the shop.<br>
     * @param address - The new address as a String.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Updates the stock of potions in the shop.<br>
     * @param _stock - The new inventory of potions as an array.
     */
    public void setStock(Potion[] _stock) {
        this.stock = _stock;
    }

    //---------------------------------------
    // Business Methods
    //---------------------------------------

    /**
     * Finds a potion in the stock by its id.
     *
     * @param potionId The ID of the potion to search for.
     * @return The Potion object if found, or null if not found.
     */
    public Potion findPotion(String potionId) {
        for (Potion potion : stock) {
            if (potion != null) {
                if (potion.getId().equalsIgnoreCase(potionId)) {
                    return potion;
                }
            }
        }
        return null;
    }

    /**
     * Finds a potion in the stock by its id and specified quantity.
     *
     * @param potionId The ID of the potion to search for.
     * @param quantity The quantity to search for.
     * @return The Potion object if found, or null if not found.
     */
    public Potion findPotion(String potionId, int quantity) {
        for (Potion potion : stock) {
            if (potion != null) {
                if (potion.getId().equalsIgnoreCase(potionId) && potion.getStoreQuantity() == quantity) {
                    return potion;
                }
            }
        }
        return null;
    }

    //---------------------------------------
    // toString
    //---------------------------------------

    /**
     * Returns a string representation of the shop.<br>
     * @return A string containing shop details.
     */
    @Override
    public String toString() {
        return "Shop{" +
                "id='" + getId() + "', name='" + getName() + "', address='" + address + "', stock=" + Arrays.toString(stock) + '}';
    }
}
