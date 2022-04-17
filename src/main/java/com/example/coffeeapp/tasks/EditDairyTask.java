package com.example.coffeeapp.tasks;

import com.example.coffeeapp.data.CartManager;
import com.example.coffeeapp.data.models.constants.CoffeePrice;
import com.example.coffeeapp.data.models.constants.Dairy;

public class EditDairyTask implements Runnable {

    private Dairy dairy;

    public EditDairyTask(Dairy dairy) {
        this.dairy = dairy;
    }

    @Override
    public void run() {
        Dairy currentDiary = CartManager.GetInstance().GetCurrentItem().getMilk();
        if (currentDiary == Dairy.ALMOND || currentDiary == Dairy.SOY) {
            CartManager.GetInstance().GetCurrentItem().setPrice(
                    CartManager.GetInstance().GetCurrentItem().getPrice().subtract(CoffeePrice.NON_DAIRY_COST)
            );
        } else if (currentDiary != Dairy.NONE){
            CartManager.GetInstance().GetCurrentItem().setPrice(
                    CartManager.GetInstance().GetCurrentItem().getPrice().subtract(CoffeePrice.DAIRY_COST)
            );
        }
        CartManager.GetInstance().GetCurrentItem().setMilk(dairy);
        if (dairy == Dairy.ALMOND || dairy == Dairy.SOY) {
            CartManager.GetInstance().GetCurrentItem().setPrice(
                    CartManager.GetInstance().GetCurrentItem().getPrice().add(CoffeePrice.NON_DAIRY_COST)
            );
        } else if (dairy != Dairy.NONE){
            CartManager.GetInstance().GetCurrentItem().setPrice(
                    CartManager.GetInstance().GetCurrentItem().getPrice().add(CoffeePrice.DAIRY_COST)
            );
        }
    }
}
