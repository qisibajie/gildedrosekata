package com.refactor.homework;

public class ItemFactory {
    public static Item newInstance(String name, int sellIn, int quality) {
        if (name.equals("Aged Brie")) {
            return new AgedBrie(name, sellIn, quality);
        }
        if (name.equals("Elixir of the Mongoose")) {
            return new MongooseElixir(name, sellIn, quality);
        }
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras(name, sellIn, quality);
        }
        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePasses(name, sellIn, quality);
        }
        if (name.equals("Conjured Mana Cake")) {
            return new ConJuredMana(name, sellIn, quality);
        }
        return new DexterityItem(name, sellIn, quality);
    }
}
