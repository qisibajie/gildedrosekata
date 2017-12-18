package com.refactor.composite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagTest {
    private static final String SIMPLE_PRICE = "8.95";
    @Test
    public void testSimpleTagWithOneAttributeAndValue(){
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency", "USD");
        priceTag.addValue(SIMPLE_PRICE);
        String expected =
                "<price currency="+
                        "'"+
                        "USD"+
                        "'>"+
                        SIMPLE_PRICE+
                        "</price>";
        assertEquals("price XML", expected, priceTag.toString());
    }
}
