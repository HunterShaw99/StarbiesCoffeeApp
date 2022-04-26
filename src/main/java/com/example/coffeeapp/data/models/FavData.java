package com.example.coffeeapp.data.models;

import java.io.Serializable;
import java.util.List;

public class FavData extends CoffeeData implements Serializable {

    private List<CoffeeModel> favs;

    public FavData(List<CoffeeModel> favs) {
        this.favs = favs;
    }

    public List<CoffeeModel> getFavs() {
        return favs;
    }
}
