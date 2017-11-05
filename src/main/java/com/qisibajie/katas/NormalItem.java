package com.qisibajie.katas;

public class NormalItem extends Item{
    private NormalItem(int sellIn, int quality) {
        super(sellIn, quality);
    }

    public NormalItem update() {
        return new NormalItem(sellIn - 1, notNegative(sellIn > 0 ? quality - 1 : quality - 2));
    }

    private int notNegative(int quality) {
        return quality < 0? 0: quality;
    }

    public static NormalItem newInstanceWithSellInAndQuality(int sellIn, int quality) {
        if(quality >50 || quality < 0){
            throw  new IllegalArgumentException("Quality should be between 0 and 50");
        }
        return new NormalItem(sellIn, quality);
    }
}
