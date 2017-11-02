package com.qisibajie.katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    @Test
    public void at_the_end_of_each_day_our_system_lowers_sellIn_and_quality_values_by_1_if_sellIn_is_greater_than_0_for_normal_items() {
        //given
        NormalItem normalItem = new NormalItem(10, 15);
        //when
        NormalItem updatedItem = normalItem.update();

        //then
        assertEquals(9,updatedItem.getSellIn());
        assertEquals(14,updatedItem.getQuality());
    }
}
