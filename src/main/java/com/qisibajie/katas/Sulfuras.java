package com.qisibajie.katas;

public class Sulfuras extends Item {
    private Sulfuras(int sellIn, int quality) {
        super(sellIn, quality);
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
}
