package com.refactor.homework;

public class AgedBrie extends Item {
    AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality(int sellIn, int quality) {
        if (sellIn <= 0) {
            setQuality(notGreaterThanFifty(quality + 2));
        } else {
            setQuality(notGreaterThanFifty(quality + 1));
        }
    }

    @Override
    protected void updateSellIn(int sellIn) {
        setSellIn(sellIn - 1);
    }
}
