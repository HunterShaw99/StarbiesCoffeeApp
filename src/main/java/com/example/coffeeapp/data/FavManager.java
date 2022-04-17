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



public class FavManager implements Subject {

    private volatile static FavManager instance = null;
    private static ObservableList<CoffeeModel> _currentOrder;
    private static CoffeeModel currentItem;
    private static ObservableList<CoffeeModel> currentItemList;
    private List<Observer> observers;
    private FavManager() {
        _currentOrder = FXCollections.observableArrayList();
        currentItemList = FXCollections.observableArrayList();
        observers = new ArrayList<>();
    }

    public static FavManager GetInstance() {
        if (instance == null) {
            synchronized (CartManager.class) {
                if (instance == null) {
                    instance = new FavManager();
                }
            }
        }
        return instance;
    }


    public void AddBeverage(CoffeeModel toAdd) {
        _currentOrder.add(toAdd);
        notifyObservers();
    }

    public void RemoveBeverage(CoffeeModel toRemove) {
        if (_currentOrder.contains(toRemove)) _currentOrder.remove(toRemove);;
        notifyObservers();
    }

    public CoffeeModel GetBeverage(UUID beverageID) {
        for (CoffeeModel e : _currentOrder) {
            if (e.getItemID().equals(beverageID)) return e;
        }
        return null;
    }


    public ObservableList<CoffeeModel> GetFavItems() {
        return _currentOrder;
    }

    /**
     * Method for specifying a CoffeeModel item. Mostly used for communication between certain pages.
     * @return Selected item.
     */
    public CoffeeModel GetCurrentItem() {
        return currentItem;
    }

    public ObservableList<CoffeeModel> GetCurrentItemList() {
        return currentItemList;
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

    }
}
