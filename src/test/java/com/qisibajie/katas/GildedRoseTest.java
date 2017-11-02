package com.qisibajie.katas;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    @Test
    public void at_the_end_of_each_day_our_system_lowers_sellIn_and_quality_values_by_1_if_sellIn_is_greater_than_0_for_normal_items() {
        //given
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(10, 15);
        //when
        NormalItem updatedItem = normalItem.update();

        //then
        assertThat(updatedItem.getSellIn(), is(9));
        assertEquals(14,updatedItem.getQuality());
    }

    @Test
    public void once_the_sell_by_date_has_passed_quality_of_normal_items_degrades_twice_as_fast(){
        //given
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(0, 20);
        //when
        NormalItem updatedItem = normalItem.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-1));
        assertThat(updatedItem.getQuality(), is(18));
    }

    @Test
    public void the_quality_of_normal_items_should_be_greater_than_or_equal_to_0(){
        //given
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(0, 0);
        //when
        NormalItem updatedItem = normalItem.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-1));
        assertThat(updatedItem.getQuality(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void the_quality_of_normal_items_should_be_no_more_than_50(){
        //given
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(0, 51);
    }

    @Test
    public void the_Aged_Brie_actually_increases_in_Quality_by_1_the_older_it_gets(){
        //given
        AgedBrie agedBrie = AgedBrie.newInstanceWithSellInAndQuality(0, 0);
        //when
        AgedBrie updatedItem = agedBrie.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-1));
        assertThat(updatedItem.getQuality(), is(1));
    }

    @Test
    public void the_quality_of_Aged_Brie_should_not_exceed_50(){
        //given
        AgedBrie agedBrie = AgedBrie.newInstanceWithSellInAndQuality(-1, 50);
        //when
        AgedBrie updatedItem = agedBrie.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-2));
        assertThat(updatedItem.getQuality(), is(50));
    }


    @Test(expected = IllegalArgumentException.class)
    public void the_quality_of_aged_brie_items_should_be_no_more_than_50(){
        //given
        AgedBrie agedBrie = AgedBrie.newInstanceWithSellInAndQuality(0, 51);
    }

}
