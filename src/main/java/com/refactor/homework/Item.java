package com.refactor.homework;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    public void updateItem() {
        if ((!"Aged Brie".equals(getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(getName())) {
            if (getQuality() > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
                    setQuality(getQuality() - 1);
                }
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

    private int notLessThanZero(int quality) {
        return quality < 0 ? 0 : quality;
    }

    private int notGreaterThanFifty(int quality) {
        return quality > 50 ? 50 : quality;
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
