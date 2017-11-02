package com.qisibajie.katas;

public class Sulfuras {
    private final int quality;
    private final int sellIn;

    private Sulfuras(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Sulfuras newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if(quality != 80){
            throw new IllegalArgumentException("Sulfuras quality should always be 80");
        }
        return new Sulfuras(sellIn, quality);
    }

    public Sulfuras update() {
        return new Sulfuras(sellIn-1, 80);
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }
}
