package com.refactor.composite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class XmlBuilderTest {

    @Test
    public void testToXml(){
        Product productA = new Product("f1234", "medium", "USD", "red", 8.95, "Fire Truck");
        Product productB = new Product("p1112", "NOT_APPLICABLE", "USD", "red", 230.0, "Hello World");
        Order order = new Order("321");
        order.addProduct(productA);
        order.addProduct(productB);
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);
        System.out.println(new XmlBuilder().getContents(orders));
    }

}