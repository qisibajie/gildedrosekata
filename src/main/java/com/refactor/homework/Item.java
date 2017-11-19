package com.refactor.homework;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    protected void updateItem() {
        newInstance(getName(), getSellIn(), getQuality()).updateItem();
    }

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

    protected int notLessThanZero(int quality) {
        return quality < 0 ? 0 : quality;
    }

    protected int notGreaterThanFifty(int quality) {
        return quality > 50 ? 50 : quality;
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }


}
