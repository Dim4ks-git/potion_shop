//--------------------------------------------------
// IMPORTS
//--------------------------------------------------

package com.potionshop.models;

//--------------------------------------------------
// CLASS Entity
//--------------------------------------------------
/**
 * Represents a base class for all entities in the Potion Shop system.<br>
 * Each entity has a unique identifier and a name.
 */
public class Entity {

    //---------------------------------------
    // Fields
    //---------------------------------------
    private String id;
    private String name;

    //---------------------------------------
    // Constructors
    //---------------------------------------

    /**
     * Default constructor for creating an Entity with default values.<br>
     * Initializes the ID and name to "default".
     */
    public Entity() {
        this.id = "default";
        this.name = "default";
    }

    /**
     * Parameterized constructor for creating an Entity with specified details.<br>
     * @param _id - The unique identifier for the entity.
     * @param _name - The name of the entity.
     */
    public Entity(String _id, String _name) {
        this.id = _id;
        this.name = _name;
    }

    /**
     * Copy constructor for creating a new Entity as a copy of an existing one.<br>
     * @param other - The Entity object to copy.
     */
    public Entity(Entity other) {
        this.id = other.id;
        this.name = other.name;
    }

    //---------------------------------------
    // Get Methods
    //---------------------------------------

    /**
     * Retrieves the unique identifier of the entity.<br>
     * @return The ID as a String.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the name of the entity.<br>
     * @return The name as a String.
     */
    public String getName() {
        return name;
    }

    //---------------------------------------
    // Set Methods
    //---------------------------------------

    /**
     * Updates the unique identifier of the entity.<br>
     * @param id - The new ID as a String.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Updates the name of the entity.<br>
     * @param name - The new name as a String.
     */
    public void setName(String name) {
        this.name = name;
    }

    //---------------------------------------
    // toString
    //---------------------------------------

    /**
     * Returns a string representation of the entity.<br>
     * @return A string containing entity details.
     */
    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + "', name='" + name + "'}";
    }
}
