package com.qisibajie.katas.com.qisibajie.katas.behavior.com.qisibajie.katas.behavior.impl;

import com.qisibajie.katas.AgedBrie;
import com.qisibajie.katas.Item;
import com.qisibajie.katas.com.qisibajie.katas.behavior.ItemUpdate;

public class AgedBrieUpdate implements ItemUpdate {
    @Override
    public Item update(int sellIn, int quality) {
        return AgedBrie.newInstanceWithSellInAndQuality(sellIn - 1, quality < 50 ? quality + 1 : quality);
    }
}
