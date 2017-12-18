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
        return xml.toString();
    }

    private void writeProductsTo(StringBuilder xml, Order order) {
        for (int j = 0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            xml.append("<product");
            xml.append(" id='");
            xml.append(product.getID());
            xml.append("'");
            xml.append(" color='");
            xml.append(getColorFor(product));
            xml.append("'");
            if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                xml.append(" size='");
                xml.append(getSizeFor(product));
                xml.append("'");
            }
            xml.append(">");
            xml.append("<price");
            xml.append(" currency='");
            xml.append(getCurrentFor(product));
            xml.append("'>");
            xml.append(product.getPrice());
            xml.append("</price>");
            xml.append(product.getName());
            xml.append("</product>");
        }
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
