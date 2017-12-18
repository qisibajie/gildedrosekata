package com.refactor.composite;

import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<Product> products = new ArrayList<>();

    public Order(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void addProduct(Product productA) {
        products.add(productA);
    }
}
