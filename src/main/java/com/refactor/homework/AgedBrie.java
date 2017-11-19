package com.refactor.homework;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {

        setQuality(notGreaterThanFifty(getQuality() + 1));
        setSellIn(getSellIn() - 1);

        if (getSellIn() < 0) {
            setQuality(notGreaterThanFifty(getQuality() + 1));

        }
    }
}
