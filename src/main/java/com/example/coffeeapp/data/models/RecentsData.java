package com.example.coffeeapp.data.models;

import java.io.Serializable;
import java.util.List;

public class RecentsData extends CoffeeData implements Serializable {

    private List<CoffeeModel> recents;

    public RecentsData(List<CoffeeModel> recents) {
        this.recents = recents;
    }

    public List<CoffeeModel> getRecents() {
        return recents;
    }
}
