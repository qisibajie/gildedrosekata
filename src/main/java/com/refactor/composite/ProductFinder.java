package com.refactor.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ProductFinder {
    public List belowPriceAvoidingAColor(float price, Color color) {
        List foundProducts = new ArrayList();
        ArrayBlockingQueue<Object> repository = null;
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (product.getPrice() < price && product.getColor() != color.toString()) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
}
