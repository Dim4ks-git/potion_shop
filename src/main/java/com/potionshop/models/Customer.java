package com.potionshop.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//--------------------------------------------------
//
// CLASS Customer
//
//--------------------------------------------------

public class Customer extends Entity {
    private String email;
    private String password;
    private List<Order> ordersHistory;

    public Customer(String _id, String _name, String _email, String _password) {
        super(_id, _name);
        this.email = _email;
        this.password = _password;
        this.ordersHistory = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Order> getOrdersHistory() {
        return ordersHistory;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrdersHistory(List<Order> orders) {
        this.ordersHistory = orders;
    }

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
}
