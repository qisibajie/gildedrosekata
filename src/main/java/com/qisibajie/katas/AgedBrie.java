package com.qisibajie.katas;

public class AgedBrie extends Item {


    private AgedBrie(int sellIn, int quality) {
        super(sellIn, quality);
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
}
