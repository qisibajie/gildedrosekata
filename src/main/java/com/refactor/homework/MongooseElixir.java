package com.refactor.homework;

public class MongooseElixir extends Item {
    MongooseElixir(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality(int sellIn, int quality) {
        if (sellIn <= 0) {
            setQuality(notLessThanZero(quality - 2));
        } else {
            setQuality(notLessThanZero(quality - 1));
        }
    }

    @Override
    protected void updateSellIn(int sellIn) {
        setSellIn(sellIn - 1);
    }
}
