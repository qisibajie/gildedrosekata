package com.qisibajie.katas;

import com.qisibajie.katas.com.qisibajie.katas.behavior.com.qisibajie.katas.behavior.impl.SulfurasUpdate;

public class Sulfuras extends Item {
    private Sulfuras(int sellIn, int quality) {
        super(sellIn, quality);
        this.itemUpdate = new SulfurasUpdate();
    }

    public static Sulfuras newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if(quality != 80){
            throw new IllegalArgumentException("Sulfuras quality should always be 80");
        }
        return new Sulfuras(sellIn, quality);
    }
}
