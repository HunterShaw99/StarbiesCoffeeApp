package com.example.coffeeapp.data;


import com.example.coffeeapp.data.models.CoffeeModel;
import com.example.coffeeapp.observer.Observer;
import com.example.coffeeapp.observer.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * CartManager allows for ease of communication between different scenes needing data from the cart.
 * @author Hunter
 */
public class CoffeeManager implements Subject {

    private volatile static CoffeeManager instance = null;
    private static ObservableList<CoffeeModel> cartLIST;
    private static ObservableList<CoffeeModel> favLIST;
    private static ObservableList<CoffeeModel> recentLIST;
    private static CoffeeModel currentItem;
    private static ObservableList<CoffeeModel> currentItemList;
    private List<Observer> observers;
    private CoffeeManager() {
        cartLIST = FXCollections.observableArrayList();
        favLIST = FXCollections.observableArrayList();
        recentLIST = FXCollections.observableArrayList();
        currentItemList = FXCollections.observableArrayList();
        observers = new ArrayList<>();
    }

    /**
     * Method for getting the CartManager object.
     * @return instance of the CartManager class.
     */
    public static CoffeeManager getInstance() {
        if (instance == null) {
            synchronized (CoffeeManager.class) {
                if (instance == null) {
                    instance = new CoffeeManager();
                }
            }
        }
        return instance;
    }

    /**
     * Method which allows for safe adding to the current order.
     * @param toAdd
     */
    public void addBeverageCart(CoffeeModel toAdd) {
        cartLIST.add(toAdd);
        notifyObservers();
    }

    public void addBeverageFav(CoffeeModel toAdd) {
        toAdd.setRedHeart("True");
        toAdd.setFavOrRec(1);
        favLIST.add(toAdd);
    }

    public void addBeverageRecents(CoffeeModel toAdd){
        toAdd.setRedHeart("False");
        recentLIST.add(toAdd);
    }

    /**
     * Method to remove specified CoffeeModel item from the current order.
     * @param toRemove
     */
    public void removeBeverageCart(CoffeeModel toRemove) {
        if (cartLIST.contains(toRemove)) cartLIST.remove(toRemove);;
        notifyObservers();
    }

    public void removeBeverageFavs(CoffeeModel toRemove) {
        if (favLIST.contains(toRemove)) favLIST.remove(toRemove);;
        notifyObservers();
    }

    public void removeBeverageFav(CoffeeModel toRemove) {
        if (favLIST.contains(toRemove)) favLIST.remove(toRemove);
    }

    public CoffeeModel getBeverageCart(UUID beverageID) {
        for (CoffeeModel e : cartLIST) {
            if (e.getItemID().equals(beverageID)) return e;
        }
        return null;
    }

    public CoffeeModel getBeverageFavs(UUID beverageID) {
        for (CoffeeModel e : favLIST) {
            if (e.getItemID().equals(beverageID)) return e;
        }
        return null;
    }

    public CoffeeModel getBeverageRecents(UUID beverageID) {
        for (CoffeeModel e : recentLIST) {
            if (e.getItemID().equals(beverageID)) return e;
        }
        return null;
    }

    /**
     * Method to clear the current order.
     */
    public void emptyCart() {
        cartLIST.clear();
        notifyObservers();
    }

    /**
     * Check if the cart of the current order is empty or populated.
     * @return boolean value depending on if cart is empty or not.
     */
    public boolean isEmptyCart() {
        return cartLIST.size() == 0;
    }

    /**
     * Method that uses BigDecimal for handling monetary value. Sums the total of all CoffeeModel items in the current
     * order.
     * @return String that represents the aggregate of entire cart.
     */
    public BigDecimal getTotalCart() {
        BigDecimal cartTotal = BigDecimal.ZERO;
        for (CoffeeModel c : cartLIST) {
            cartTotal = cartTotal.add(c.getPrice());
        }
        return cartTotal;
    }

    /**
     * Method for allowing binding of the underlying ObservableList (which represents the current orders cart) to ListViews.
     * @return Returns the current orders cart as a reference.
     */
    public ObservableList<CoffeeModel> getItemsCart() {
        return cartLIST;
    }

    public ObservableList<CoffeeModel> getItemsFav() {
        return favLIST;
    }

    public ObservableList<CoffeeModel> getRecentLIST() {return recentLIST;}

    /**
     * Method for specifying a CoffeeModel item. Mostly used for communication between certain pages.
     * @return Selected item.
     */
    public CoffeeModel getCurrentItem() {
        return currentItem;
    }

    public ObservableList<CoffeeModel> getCurrentItemList() {
        return currentItemList;
    }
    /**
     * Sets the specified CoffeeModel item to m.
     * @param m
     */
    public void setCurrentItem(CoffeeModel m) {
        currentItemList.clear();
        currentItem = m;
        currentItemList.add(m);
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)) observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(getTotalCart());
        }
    }
}
