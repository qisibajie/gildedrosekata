package com.qisibajie.katas.com.qisibajie.katas.behavior.com.qisibajie.katas.behavior.impl;

import com.qisibajie.katas.BackstagePasses;
import com.qisibajie.katas.Item;
import com.qisibajie.katas.com.qisibajie.katas.behavior.ItemUpdate;

public class BackstagePassesUpdate implements ItemUpdate {
    @Override
    public Item update(int sellIn, int quality) {
        return BackstagePasses.newInstanceWithSellInAndQuality(sellIn - 1, notGreaterThanFifty((sellIn <= 0) ? 0 : ((sellIn > 5) ? ((sellIn <= 10) ? (quality + 2) : (quality + 1)) : (quality + 3))));
    }

    private int notGreaterThanFifty(int quality) {
        return quality > 50 ? 50 : quality;
    }
}
