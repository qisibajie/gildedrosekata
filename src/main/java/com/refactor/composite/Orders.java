package com.refactor.composite;

import java.util.List;

public class Orders {
    private List<Order> orders;
    private int orderCount;

    public int getOrderCount() {
        return orderCount;
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }
}
