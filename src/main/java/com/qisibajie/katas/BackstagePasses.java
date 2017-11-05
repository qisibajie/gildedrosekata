package com.qisibajie.katas;

import com.qisibajie.katas.com.qisibajie.katas.behavior.com.qisibajie.katas.behavior.impl.BackstagePassesUpdate;

public class BackstagePasses extends Item {
    private BackstagePasses(int sellIn, int quality) {
        super(sellIn, quality);
        this.itemUpdate = new BackstagePassesUpdate();
    }

    public static BackstagePasses newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if (quality < 0 || quality > 50) {
            throw new IllegalArgumentException("Quality should be between 0 and 50");
        }
        return new BackstagePasses(sellIn, quality);
    }
}
