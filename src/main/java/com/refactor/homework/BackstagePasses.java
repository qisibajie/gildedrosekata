package com.refactor.homework;

public class BackstagePasses extends Item {
    BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality(int sellIn, int quality) {
        if (sellIn >= 11) {
            setQuality(notGreaterThanFifty(quality + 1));
        }
        if (sellIn >= 6 && sellIn < 11) {
            setQuality(notGreaterThanFifty(quality + 2));
        }
        if (sellIn > 0 && sellIn < 6) {
            setQuality(notGreaterThanFifty(quality + 3));
        }
        if (sellIn <= 0) {
            setQuality(0);
        }
    }

    @Override
    protected void updateSellIn(int sellIn) {
        setSellIn(sellIn - 1);
    }
}
