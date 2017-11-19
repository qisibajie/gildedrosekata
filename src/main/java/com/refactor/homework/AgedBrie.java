package com.refactor.homework;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        if (getSellIn() <= 0) {
            setQuality(notGreaterThanFifty(getQuality() + 2));

        } else {
            setQuality(notGreaterThanFifty(getQuality() + 1));
        }
        setSellIn(getSellIn() - 1);
    }
}
