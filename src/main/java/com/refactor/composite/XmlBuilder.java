package com.refactor.composite;

import com.sun.deploy.util.OrderedHashSet;

import java.util.List;

public class XmlBuilder {
    private Orders orders;

    public XmlBuilder(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuilder xml = new StringBuilder();
        writeOrdersTo(xml);
        return xml.toString();
    }

    private void writeOrdersTo(StringBuilder xml) {
        TagNode ordersNode = new TagNode("orders");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            TagNode orderNode = new TagNode("order");
            orderNode.addAttribute("id", order.getOrderId());

            writeProductsTo(orderNode, order);
            ordersNode.add(orderNode);
        }
        xml.append(ordersNode.toString());
    }

    private void writeProductsTo(TagNode orderTag, Order order) {
        for (int j = 0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            TagNode productNode = new TagNode("product");
            productNode.addAttribute("id", product.getID());
            productNode.addAttribute("color", getColorFor(product));

            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                productNode.addAttribute("size", getSizeFor(product));
            }
            writePriceTo(productNode, product);
            productNode.addValue(product.getName());
            orderTag.add(productNode);
        }
    }

    private void writePriceTo(TagNode productNode, Product product) {
        TagNode priceNode = new TagNode("price");
        priceNode.addAttribute("currency", "USD");
        priceNode.addValue(priceFor(product));
        productNode.add(priceNode);
    }

    private String priceFor(Product product) {
        return String.valueOf(product.getPrice());
    }

    private String getCurrentFor(Product product) {
        return product.getCurrency();
    }

    private String getSizeFor(Product product) {
        return product.getSize();
    }

    private String getColorFor(Product product) {
        return product.getColor();
    }
}
