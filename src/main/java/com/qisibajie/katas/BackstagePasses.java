package com.qisibajie.katas;

public class BackstagePasses {
    private final int quality;
    private final int sellIn;

    public BackstagePasses(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static BackstagePasses newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if (quality < 0 || quality > 50) {
            throw new IllegalArgumentException("Quality should be between 0 and 50");
        }
        return new BackstagePasses(sellIn, quality);
    }

    public BackstagePasses update() {
        return new BackstagePasses(sellIn - 1, notGreaterThanFifty(sellIn <= 0 ? 0 : (sellIn <= 5 ? (quality + 3) : (sellIn <= 10 ? quality + 2 : quality + 1))));
    }

    private int notGreaterThanFifty(int quality) {
        return quality > 50 ? 50 : quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }
}
