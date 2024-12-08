package com.potionshop.models;

public class Customer extends Entity {
    private String email;
    private String password;
    private Order[] ordersHistory;

    public Customer(String _id, String _name, String _email, String _password, Order[] _ordersHistory) {
        super(_id, _name);
        this.email = _email;
        this.password = _password;
        this.ordersHistory = _ordersHistory;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Order[] getOrdersHistory() {
        return ordersHistory;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrdersHistory(Order[] ordersHistory) {
        this.ordersHistory = ordersHistory;
    }
}

