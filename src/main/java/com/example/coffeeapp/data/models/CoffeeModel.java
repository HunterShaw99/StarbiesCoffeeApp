package com.example.coffeeapp.data.models;



import com.example.coffeeapp.data.models.constants.Dairy;
import com.example.coffeeapp.data.models.constants.Flavor;
import com.example.coffeeapp.data.models.constants.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//each coffee model will have: a name, the chosen size, the chosen milk, the chosen flavors,
//                            the total price, and the prices per size.
public class CoffeeModel implements Serializable {

    private UUID itemID;
    private String name;
    private Size size;
    private Dairy milk;
    private List<Flavor> flavors;
    private BigDecimal price;
    private String image;

    public CoffeeModel() {
        itemID = UUID.randomUUID();
        this.price = BigDecimal.ZERO;
        this.flavors = new ArrayList<Flavor>();
    }

    public CoffeeModel(String imageURL, BigDecimal price) {
        itemID = UUID.randomUUID();
        image = imageURL;
        this.price = price;
        this.flavors = new ArrayList<Flavor>();
    }

    public UUID getItemID() {
        return this.itemID;
    }

    public String toString() {
        return name+" Price:"+price.toString()+" Flavors:"+flavors.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setMilk(Dairy milk) {
        this.milk = milk;
    }

    public Dairy getMilk() {
        return milk;
    }

    public ArrayList<Flavor> getFlavors() {
        ArrayList<Flavor> f = new ArrayList<>(flavors);
        return f;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void addFlavor(Flavor flavor) {
        flavors.add(flavor);
    }

    public void removeFlavor(Flavor flavor) {
        flavors.remove(flavor);
    }

    public String getImage() {
        return image;
    }
}
