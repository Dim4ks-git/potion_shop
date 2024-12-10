package com.potionshop.models;

//--------------------------------------------------
//
// CLASS Shop
//
//--------------------------------------------------

public class Shop extends Entity {
    private String address;
    private Potion[] stock;

    public Shop(String _id, String _name, String _address, Potion[] _stock) {
        super(_id, _name);
        this.address = _address;
        this.stock = _stock;
    }

    public String getAddress() {
        return address;
    }

    public Potion[] getStock() {
        return stock;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setStock(Potion[] _stock) {
        this.stock = _stock;
    }

}
