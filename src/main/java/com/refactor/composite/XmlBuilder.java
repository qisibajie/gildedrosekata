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
        xml.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            xml.append("<order");
            xml.append(" id='");
            xml.append(order.getOrderId());
            xml.append("'>");
            writeProductsTo(xml, order);
            xml.append("</order>");
        }
        xml.append("</orders>");
    }

    private void writeProductsTo(StringBuilder xml, Order order) {
        for (int j = 0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            TagNode productNode = new TagNode("product");
            productNode.addAttribute("id", product.getID());
            productNode.addAttribute("color", getColorFor(product));

            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                productNode.addAttribute("size", getSizeFor(product));
            }
            writePriceTo(xml, product);
            xml.append(product.getName());
            xml.append(productNode.toString());
        }
    }

    private void writePriceTo(StringBuilder xml, Product product) {
        TagNode priceNode = new TagNode("price");
        priceNode.addAttribute("currency", "USD");
        priceNode.addValue(priceFor(product));
        xml.append(priceNode.toString());
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
