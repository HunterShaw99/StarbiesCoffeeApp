package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.data.models.constants.Flavor;

public class CartAddTask implements Runnable {
    @Override
    public void run() {
        CoffeeModel m = CartManager.GetInstance().GetCurrentItem();
        if (m.getFlavors().size() == 0) m.addFlavor(Flavor.NONE);
        CartManager.GetInstance().AddBeverage(m);
        CartManager.GetInstance().SetCurrentItem(null);
    }
}
