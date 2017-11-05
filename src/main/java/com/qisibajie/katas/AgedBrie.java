package com.qisibajie.katas;

import com.qisibajie.katas.com.qisibajie.katas.behavior.com.qisibajie.katas.behavior.impl.AgedBrieUpdate;

public class AgedBrie extends Item {


    private AgedBrie(int sellIn, int quality) {
        super(sellIn, quality);
        this.itemUpdate = new AgedBrieUpdate();
    }

    public static AgedBrie newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if (quality > 50 || quality < 0) {
            throw new IllegalArgumentException("Quality should be between 0 and 50.");
        }
        return new AgedBrie(sellIn, quality);
    }
}
