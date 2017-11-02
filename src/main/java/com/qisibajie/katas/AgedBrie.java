package com.qisibajie.katas;

public class AgedBrie {
    private final int sellIn;
    private final int quality;

    private AgedBrie(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static AgedBrie newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if (quality > 50 || quality < 0) {
            throw new IllegalArgumentException("Quality should be between 0 and 50.");
        }
        return new AgedBrie(sellIn, quality);
    }

    public AgedBrie update() {
        return new AgedBrie(sellIn - 1, quality < 50 ? quality + 1 : quality);
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }
}
