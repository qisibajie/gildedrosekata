package com.refactor.homework;

public class BackstagePasses extends Item {
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {

        if (getSellIn() >= 11) {
            setQuality(notGreaterThanFifty(getQuality() + 1));
        }
        if (getSellIn() >= 6 && getSellIn() < 11) {
            setQuality(notGreaterThanFifty(getQuality() + 2));
        }
        if (getSellIn() > 0 && getSellIn() < 6) {
            setQuality(notGreaterThanFifty(getQuality() + 3));
        }
        if (getSellIn() <= 0) {
            setQuality(0);
        }
        setSellIn(getSellIn() - 1);
    }
}
