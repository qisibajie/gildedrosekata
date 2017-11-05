package com.qisibajie.katas.com.qisibajie.katas.behavior.com.qisibajie.katas.behavior.impl;

import com.qisibajie.katas.Item;
import com.qisibajie.katas.Sulfuras;
import com.qisibajie.katas.com.qisibajie.katas.behavior.ItemUpdate;

public class SulfurasUpdate implements ItemUpdate {
    @Override
    public Item update(int sellIn, int quality) {
        return Sulfuras.newInstanceWithSellInAndQuality(sellIn-1, 80);
    }
}
