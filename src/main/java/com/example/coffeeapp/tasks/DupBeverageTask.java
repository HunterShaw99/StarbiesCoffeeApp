package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.CoffeeModel;

import java.util.UUID;

public class DupBeverageTask implements Runnable {

    private UUID toAdd;

    public DupBeverageTask(UUID mID) {
        toAdd = mID;
    }

    @Override
    public void run() {
        CoffeeModel m = new CoffeeModel(CartManager.GetInstance().GetBeverage(toAdd));
        CartManager.GetInstance().AddBeverage(m);
        System.out.println(m);
        m = null;
    }
}