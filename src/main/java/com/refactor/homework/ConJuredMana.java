package com.refactor.homework;

public class ConJuredMana extends Item {
    public ConJuredMana(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {

        if (getSellIn() <= 0) {
            setQuality(notLessThanZero(getQuality() - 2));
        } else {
            setQuality(notLessThanZero(getQuality() - 1));
        }
        setSellIn(getSellIn() - 1);
    }
}
