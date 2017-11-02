package com.qisibajie.katas;

public class NormalItem {
    private final int quality;
    private final int sellIn;

    public NormalItem(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public NormalItem update() {
        return new NormalItem(sellIn-1, quality-1);
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }
}
