package com.refactor.composite;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<>();

    public int getOrderCount() {
        return orders.size();
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
