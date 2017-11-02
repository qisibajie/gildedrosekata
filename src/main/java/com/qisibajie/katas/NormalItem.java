package com.qisibajie.katas;

public class NormalItem {
    private final int quality;
    private final int sellIn;

    private NormalItem(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public NormalItem update() {
        return new NormalItem(sellIn - 1, notNegative(sellIn > 0 ? quality - 1 : quality - 2));
    }

    private int notNegative(int quality) {
        return quality < 0? 0: quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

    public static NormalItem newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if(quality >50 || quality < 0){
            throw  new IllegalArgumentException("Quality should be between 0 and 50");
        }
        return new NormalItem(sellIn, quality);
    }
}
