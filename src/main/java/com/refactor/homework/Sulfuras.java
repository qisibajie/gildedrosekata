package com.refactor.homework;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        if ((!"Aged Brie".equals(getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(getName()) ) {
            if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
                setQuality(notLessThanZero(getQuality() - 1));
            }
        } else {
            setQuality(notGreaterThanFifty(getQuality() + 1));
            if ("Backstage passes to a TAFKAL80ETC concert".equals(getName())) {
                if (getSellIn() < 11) {
                    setQuality(notGreaterThanFifty(getQuality() + 1));
                }

                if (getSellIn() < 6) {
                    setQuality(notGreaterThanFifty(getQuality() + 1));
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
            setSellIn(getSellIn() - 1);
        }

        if (getSellIn() < 0) {
            if (!"Aged Brie".equals(getName())) {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(getName())) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
                        setQuality(notLessThanZero(getQuality() - 1));
                    }
                } else {
                    setQuality(0);
                }
            } else {
                setQuality(notGreaterThanFifty(getQuality() + 1));
            }
        }
    }
}
