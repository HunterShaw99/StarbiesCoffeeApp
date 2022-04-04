package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.CoffeeModel;

import java.util.UUID;

public class AddBeverageTask implements Runnable {

    private CoffeeModel m;

    public AddBeverageTask(UUID mID) {
        CoffeeModel d = CartManager.GetInstance().GetBeverage(mID);
        this.m = new CoffeeModel(d.getImage(), d.getPrice(), d.getFlavors(), d.getMilk(), d.getSize(), d.getName());
        d = null;
    }

    @Override
    public void run() {
        CartManager.GetInstance().AddBeverage(m);
        m = null;
    }
}
