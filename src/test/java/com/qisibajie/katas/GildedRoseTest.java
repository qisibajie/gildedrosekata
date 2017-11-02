package com.qisibajie.katas;

import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void at_the_end_of_each_day_our_system_lowers_sellIn_and_quality_values_by_1_if_sellIn_is_greater_than_0_for_normal_items() {


        //then
        assertThat(actualSellIn, is(9));
        assertThat(actualQuality, is(14));
    }
}
