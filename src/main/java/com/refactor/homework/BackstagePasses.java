package com.refactor.homework;

public class BackstagePasses extends Item {
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        setQuality(notGreaterThanFifty(getQuality() + 1));
        if (getSellIn() < 11) {
            setQuality(notGreaterThanFifty(getQuality() + 1));
        }

        if (getSellIn() < 6) {
            setQuality(notGreaterThanFifty(getQuality() + 1));
        }

        setSellIn(getSellIn() - 1);

        if (getSellIn() < 0) {
            setQuality(0);
        }
    }
}
