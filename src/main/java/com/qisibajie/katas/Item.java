package com.qisibajie.katas;

import com.qisibajie.katas.com.qisibajie.katas.behavior.ItemUpdate;

public class Item {
    protected final int sellIn;
    protected final int quality;
    ItemUpdate itemUpdate;

    public Item(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    Item update(){
        return itemUpdate.update(sellIn, quality);
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

}
