package com.qisibajie.katas;

public class Item {
    protected final int sellIn;
    protected final int quality;

    public Item(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

}
