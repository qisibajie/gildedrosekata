package com.refactor.homework;

public class Sulfuras extends Item {
    Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality(int sellIn, int quality) {
        setQuality(80);
    }

    @Override
    protected void updateSellIn(int sellIn) {
//        setSellIn(sellIn - 1);
    }
}
