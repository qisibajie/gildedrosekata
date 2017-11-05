package com.qisibajie.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseTest {
    @Test
    public void at_the_end_of_each_day_our_system_lowers_sellIn_and_quality_values_by_1_if_sellIn_is_greater_than_0_for_normal_items() {
        //given
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(10, 15);
        //when
        Item updatedItem = normalItem.update();

        //then
        assertThat(updatedItem.getSellIn(), is(9));
        assertThat(updatedItem.getQuality(), is(14));
    }

    @Test
    public void once_the_sell_by_date_has_passed_quality_of_normal_items_degrades_twice_as_fast() {
        //given
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(0, 20);
        //when
        Item updatedItem = normalItem.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-1));
        assertThat(updatedItem.getQuality(), is(18));
    }

    @Test
    public void the_quality_of_normal_items_should_be_greater_than_or_equal_to_0() {
        //given
        NormalItem normalItem = NormalItem.newInstanceWithSellInAndQuality(0, 0);
        //when
        Item updatedItem = normalItem.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-1));
        assertThat(updatedItem.getQuality(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void the_quality_of_normal_items_should_be_no_more_than_50() {
        //given
        NormalItem.newInstanceWithSellInAndQuality(0, 51);
    }

    @Test
    public void the_Aged_Brie_actually_increases_in_Quality_by_1_the_older_it_gets() {
        //given
        AgedBrie agedBrie = AgedBrie.newInstanceWithSellInAndQuality(0, 0);
        //when
        Item updatedItem = agedBrie.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-1));
        assertThat(updatedItem.getQuality(), is(1));
    }

    @Test
    public void the_quality_of_Aged_Brie_should_not_exceed_50() {
        //given
        AgedBrie agedBrie = AgedBrie.newInstanceWithSellInAndQuality(-1, 50);
        //when
        Item updatedItem = agedBrie.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-2));
        assertThat(updatedItem.getQuality(), is(50));
    }


    @Test(expected = IllegalArgumentException.class)
    public void the_quality_of_aged_brie_items_should_be_no_more_than_50() {
        //given
        AgedBrie.newInstanceWithSellInAndQuality(0, 51);
    }

    @Test
    public void the_sulfuras_is_a_legendary_item_and_as_such_its_Quality_is_80_and_it_never_alters(){
        //given
        Sulfuras sulfuras = Sulfuras.newInstanceWithSellInAndQuality(0, 80);
        //when
        Item updatedItem = sulfuras.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-1));
        assertThat(updatedItem.getQuality(), is(80));
    }


    @Test(expected = IllegalArgumentException.class)
    public void the_quality_of_sulfuras_should_always_be_80(){
        //given
        Sulfuras.newInstanceWithSellInAndQuality(0, 81);
    }

    @Test
    public void the_quality_of_backstage_passes_increases_by_1_when_the_sellIn_are_more_than_10_days(){
        //given
        BackstagePasses backstagePasses = BackstagePasses.newInstanceWithSellInAndQuality(11, 20);
        //when
        Item updatedItem = backstagePasses.update();

        //then
        assertThat(updatedItem.getSellIn(), is(10));
        assertThat(updatedItem.getQuality(), is(21));
    }

    @Test
    public void the_quality_of_backstage_passes_increases_by_2_when_the_sellIn_are_between_5_and_10_days(){
        //given
        BackstagePasses backstagePasses = BackstagePasses.newInstanceWithSellInAndQuality(10, 20);
        //when
        Item updatedItem = backstagePasses.update();

        //then
        assertThat(updatedItem.getSellIn(), is(9));
        assertThat(updatedItem.getQuality(), is(22));
    }

    @Test
    public void the_quality_of_backstage_passes_increases_by_3_when_the_sellIn_are_between_0_and_5_days(){
        //given
        BackstagePasses backstagePasses = BackstagePasses.newInstanceWithSellInAndQuality(5, 20);
        //when
        Item updatedItem = backstagePasses.update();

        //then
        assertThat(updatedItem.getSellIn(), is(4));
        assertThat(updatedItem.getQuality(), is(23));
    }

    @Test
    public void the_quality_of_backstage_passes_drops_to_0_after_the_concert(){
        //given
        BackstagePasses backstagePasses = BackstagePasses.newInstanceWithSellInAndQuality(0, 20);
        //when
        Item updatedItem = backstagePasses.update();

        //then
        assertThat(updatedItem.getSellIn(), is(-1));
        assertThat(updatedItem.getQuality(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void the_quality_of_backstage_passes_should_be_no_more_than_50(){
        //given
        BackstagePasses.newInstanceWithSellInAndQuality(0, 51);
    }

    @Test
    public void the_quality_of_backstage_passes_is_not_greater_than_50(){
        //given
        BackstagePasses backstagePasses = BackstagePasses.newInstanceWithSellInAndQuality(1, 50);
        //when
        Item updatedItem = backstagePasses.update();

        //then
        assertThat(updatedItem.getSellIn(), is(0));
        assertThat(updatedItem.getQuality(), is(50));
    }

}
