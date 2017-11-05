package com.qisibajie.katas;

import com.qisibajie.katas.com.qisibajie.katas.behavior.com.qisibajie.katas.behavior.impl.NormalUpdate;

public class NormalItem extends Item{
    private NormalItem(int sellIn, int quality) {
        super(sellIn, quality);
        this.itemUpdate = new NormalUpdate();
    }


    public static NormalItem newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if(quality >50 || quality < 0){
            throw  new IllegalArgumentException("Quality should be between 0 and 50");
        }
        return new NormalItem(sellIn, quality);
    }
}
