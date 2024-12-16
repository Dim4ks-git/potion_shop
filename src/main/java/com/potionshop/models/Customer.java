//--------------------------------------------------
// IMPORTS
//--------------------------------------------------

package com.potionshop.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//--------------------------------------------------
// CLASS Customer
//--------------------------------------------------
/**
 * Represents a customer in the Potion Shop system.<br>
 * Customers can place orders for potions and have an associated history of their purchases.
 */
public class Customer extends Entity {

    //---------------------------------------
    // Fields
    //---------------------------------------
    private String email;
    private String password;
    private List<Order> ordersHistory;

    //---------------------------------------
    // Constructors
    //---------------------------------------

    /**
     * Default constructor for creating a Customer with default values.<br>
     * Initializes fields to default states.
     */
    public Customer() {
        super();
        this.email = "default@default.com";
        this.password = "default";
        this.ordersHistory = new ArrayList<>();
    }

    /**
     * Parameterized constructor for creating a Customer with specified details.<br>
     * @param _id - The unique identifier for the customer.
     * @param _name - The name of the customer.
     * @param _email - The email address of the customer.
     * @param _password - The password for the customer's account.
     */
    public Customer(String _id, String _name, String _email, String _password) {
        super(_id, _name);
        this.email = _email;
        this.password = _password;
        this.ordersHistory = new ArrayList<>();
    }

    /**
     * Copy constructor for creating a new Customer as a copy of an existing one.<br>
     * @param other - The Customer object to copy.
     */
    public Customer(Customer other) {
        super(other);
        this.email = other.email;
        this.password = other.password;
        this.ordersHistory = new ArrayList<>(other.ordersHistory);
    }

    //---------------------------------------
    // Get Methods
    //---------------------------------------

    /**
     * Retrieves the email address of the customer.<br>
     * @return The email address as a String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the password of the customer.<br>
     * @return The password as a String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the order history of the customer.<br>
     * @return A list of orders placed by the customer.
     */
    public List<Order> getOrdersHistory() {
        return ordersHistory;
    }

    //---------------------------------------
    // Set Methods
    //---------------------------------------

    /**
     * Updates the password of the customer.<br>
     * @param password - The new password as a String.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Updates the email address of the customer.<br>
     * @param email - The new email address as a String.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Updates the order history of the customer.<br>
     * @param orders - A new list of orders to replace the existing history.
     */
    public void setOrdersHistory(List<Order> orders) {
        this.ordersHistory = orders;
    }

    //---------------------------------------
    // Business Methods
    //---------------------------------------

    /**
     * Facilitates the purchase of a potion by the customer from a shop.<br>
     * @param potion - The potion the customer wants to buy.
     * @param shop - The shop where the purchase is made.
     */
    public void buyPotion(Potion potion, Shop shop) {
        if (potion == null || shop == null) {
            throw new IllegalArgumentException("Potion or Shop cannot be null.");
        }

        // Check if the potion is available in the shop
        Potion[] stock = shop.getStock();
        boolean found = false;

        for (Potion p : stock) {
            if (p.getId().equals(potion.getId()) && p.getStoreQuantity() > 0) {
                found = true;

                // Decrease potion quantity in the shop
                p.decreaseQuantity(1);

                // Create a new order
                Order order = new Order(
                        "ORDER-" + LocalDateTime.now(),
                        "Order for " + potion.getName(),
                        LocalDateTime.now().toString(),
                        this,
                        potion
                );

                // Save the order to the customer's history
                this.ordersHistory.add(order);
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Potion not available in shop or out of stock.");
        }
    }

    //---------------------------------------
    // toString
    //---------------------------------------

    /**
     * Returns a string representation of the customer.<br>
     * @return A string containing customer details.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + "', name='" + getName() + "', email='" + email + "', ordersHistory=" + ordersHistory + '}';
    }
}
