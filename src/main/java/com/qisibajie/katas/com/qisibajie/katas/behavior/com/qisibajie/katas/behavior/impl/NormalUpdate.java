package com.qisibajie.katas.com.qisibajie.katas.behavior.com.qisibajie.katas.behavior.impl;

import com.qisibajie.katas.Item;
import com.qisibajie.katas.NormalItem;
import com.qisibajie.katas.com.qisibajie.katas.behavior.ItemUpdate;

public class NormalUpdate implements ItemUpdate {

    @Override
    public Item update(int sellIn, int quality) {
        return NormalItem.newInstanceWithSellInAndQuality(sellIn - 1, notNegative(sellIn > 0 ? quality - 1 : quality - 2));
    }

    private int notNegative(int quality) {
        return quality < 0 ? 0 : quality;
    }
}
