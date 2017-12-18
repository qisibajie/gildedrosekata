package com.refactor.composite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagTest {
    private static final String SIMPLE_PRICE = "8.95";

    @Test
    public void testSimpleTagWithOneAttributeAndValue() {
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency", "USD");
        priceTag.addValue(SIMPLE_PRICE);
        String expected =
                "<price currency=" +
                        "'" +
                        "USD" +
                        "'>" +
                        SIMPLE_PRICE +
                        "</price>";
        assertEquals("price XML", expected, priceTag.toString());
    }

    @Test
    public void testCompositeTagOneChild() {
        TagNode productTag = new TagNode("product");
        productTag.add(new TagNode("price"));
        String expected =
                "<product>" +
                        "<price>" +
                        "</price>" +
                        "</product>";
        assertEquals(expected, productTag.toString());
    }

    @Test
    public void testAddingChildrenAndGrnadChildren(){
        String expected =
                "<orders>"+
                     "<order>"+
                        "<product>" +
                                "<price>" +
                                "</price>" +
                        "</product>"+
                    "</order>" +
                "</orders>";
        TagNode ordersTag = new TagNode("orders");
        TagNode orderTag = new TagNode("order");
        TagNode productTag = new TagNode("product");
        TagNode priceTag = new TagNode("price");
        ordersTag.add(orderTag);
        orderTag.add(productTag);
        productTag.add(priceTag);
        assertEquals(expected, ordersTag.toString());
    }

}
