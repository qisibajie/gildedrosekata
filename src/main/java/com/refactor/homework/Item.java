package com.refactor.homework;

public abstract class Item {
    protected String name;
    protected int sellIn;
    protected int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    static Item newInstance(String name, int sellIn, int quality) {
        return ItemFactory.newInstance(name, sellIn, quality);
    }

    void updateItem() {
        updateQuality(getSellIn(), getQuality());
        updateSellIn(getSellIn());
    }

    protected abstract void updateQuality(int sellIn, int quality);

    protected abstract void updateSellIn(int sellIn);

    int notLessThanZero(int quality) {
        return quality < 0 ? 0 : quality;
    }

    int notGreaterThanFifty(int quality) {
        return quality > 50 ? 50 : quality;
    }

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
