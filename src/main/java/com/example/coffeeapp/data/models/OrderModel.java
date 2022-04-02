package com.example.coffeeapp.data.models;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class OrderModel implements Serializable {

    public BigDecimal orderTotal;
    public ObservableList<CoffeeModel> beverageLIST;
    public final String orderID;

    public OrderModel(BigDecimal orderTotal, ObservableList<CoffeeModel> beverageLIST) {
        this.orderTotal = orderTotal;
        this.beverageLIST = beverageLIST;
        orderID = UUID.randomUUID().toString().substring(0,11);
    }

    public BigDecimal Get_OrderTotal() {
        return orderTotal;
    }

    public ObservableList<CoffeeModel> GetBeverageList() {
        return beverageLIST;
    }

    public String GetOrderID() {
        return orderID;
    }



}
