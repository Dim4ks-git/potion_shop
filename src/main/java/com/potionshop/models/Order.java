//--------------------------------------------------
// IMPORTS
//--------------------------------------------------

package com.potionshop.models;

//--------------------------------------------------
// CLASS Order
//--------------------------------------------------
/**
 * Represents an order in the Potion Shop system.<br>
 * Each order is uniquely identified and contains details about the customer,
 * the potion purchased, and the timestamp of the transaction.
 */
public class Order extends Entity {

    //---------------------------------------
    // Fields
    //---------------------------------------
    private String timestamp;
    private Customer customer;
    private Potion potion;

    //---------------------------------------
    // Constructors
    //---------------------------------------

    /**
     * Default constructor for creating an Order with default values.<br>
     * Initializes fields to default states.
     */
    public Order() {
        super();
        this.timestamp = "0000-00-00T00:00:00Z";
        this.customer = null;
        this.potion = null;
    }

    /**
     * Parameterized constructor for creating an Order with specified details.<br>
     * @param _id - The unique identifier for the order.
     * @param _name - The name or description of the order.
     * @param _timestamp - The timestamp of when the order was created.
     * @param _customer - The customer who placed the order.
     * @param _potion - The potion being ordered.
     */
    public Order(String _id, String _name, String _timestamp, Customer _customer, Potion _potion) {
        super(_id, _name);
        this.timestamp = _timestamp;
        this.customer = _customer;
        this.potion = _potion;
    }

    /**
     * Copy constructor for creating a new Order as a copy of an existing one.<br>
     * @param other - The Order object to copy.
     */
    public Order(Order other) {
        super(other);
        this.timestamp = other.timestamp;
        this.customer = other.customer;
        this.potion = other.potion;
    }

    //---------------------------------------
    // Get Methods
    //---------------------------------------

    /**
     * Retrieves the timestamp of the order.<br>
     * @return The timestamp as a String.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Retrieves the customer associated with the order.<br>
     * @return The Customer object.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Retrieves the potion included in the order.<br>
     * @return The Potion object.
     */
    public Potion getPotion() {
        return potion;
    }

    //---------------------------------------
    // Set Methods
    //---------------------------------------

    /**
     * Updates the timestamp of the order.<br>
     * @param timestamp - The new timestamp as a String.
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Updates the customer associated with the order.<br>
     * @param customer - The new Customer object.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Updates the potion included in the order.<br>
     * @param potion - The new Potion object.
     */
    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    //---------------------------------------
    // toString
    //---------------------------------------

    /**
     * Returns a string representation of the order.<br>
     * @return A string containing order details.
     */
    @Override
    public String toString() {
        return "Order{" +
                "id='" + getId() + "', name='" + getName() + "', timestamp='" + timestamp + "', customer=" + customer + ", potion=" + potion + '}';
    }
}
