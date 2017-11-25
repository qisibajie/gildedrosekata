package com.refactor.homework;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class GildedRose {

    private static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<>();
        items.add(Item.newInstance("+5 Dexterity Vest", 10, 20));
        items.add(Item.newInstance("Aged Brie", 2, 0));
        items.add(Item.newInstance("Elixir of the Mongoose", 5, 7));
        items.add(Item.newInstance("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(Item.newInstance("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(Item.newInstance("Conjured Mana Cake", 3, 6));

        updateQuality();
    }

    public static void updateQuality() {
        for (Item item : items) {
            item.updateItem();
        }
    }

    public static void setItems(List<Item> itemList) {
        items = itemList;
    }

}