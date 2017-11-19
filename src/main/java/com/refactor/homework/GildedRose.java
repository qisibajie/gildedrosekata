package com.refactor.homework;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(Item.newInstance("+5 Dexterity Vest", 10, 20));
        items.add(Item.newInstance("Aged Brie", 2, 0));
        items.add(Item.newInstance("Elixir of the Mongoose", 5, 7));
        items.add(Item.newInstance("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(Item.newInstance("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(Item.newInstance("Conjured Mana Cake", 3, 6));

        updateQuality();


        for(Item item : items){
            if(item.getName().equals("+5 Dexterity Vest")) {
                assertThat(item.getSellIn(), is(9));
                assertThat(item.getQuality(), is(19));
            }
            if(item.getName().equals("Aged Brie")){
                assertThat(item.getSellIn(), is(1));
                assertThat(item.getQuality(), is(1));
            }
            if(item.getName().equals("Elixir of the Mongoose")){
                assertThat(item.getSellIn(), is(4));
                assertThat(item.getQuality(), is(6));
            }
            if(item.getName().equals("Sulfuras, Hand of Ragnaros")){
                assertThat(item.getSellIn(), is(0));
                assertThat(item.getQuality(), is(80));
            }
            if(item.getName().equals("Backstage passes to a TAFKAL80ETC concert")){
                assertThat(item.getSellIn(), is(14));
                assertThat(item.getQuality(), is(21));
            }
            if(item.getName().equals("Conjured Mana Cake")){
                assertThat(item.getSellIn(), is(2));
                assertThat(item.getQuality(), is(5));
            }
        }

        for(int i=0; i<10; i++){
            updateQuality();
        }

        for(Item item : items){
            if(item.getName().equals("+5 Dexterity Vest")) {
                assertThat(item.getSellIn(), is(-1));
                assertThat(item.getQuality(), is(8));
            }
            if(item.getName().equals("Aged Brie")){
                assertThat(item.getSellIn(), is(-9));
                assertThat(item.getQuality(), is(20));
            }
            if(item.getName().equals("Elixir of the Mongoose")){
                assertThat(item.getSellIn(), is(-6));
                assertThat(item.getQuality(), is(0));
            }
            if(item.getName().equals("Sulfuras, Hand of Ragnaros")){
                assertThat(item.getSellIn(), is(0));
                assertThat(item.getQuality(), is(80));
            }
            if(item.getName().equals("Backstage passes to a TAFKAL80ETC concert")){
                assertThat(item.getSellIn(), is(4));
                assertThat(item.getQuality(), is(38));
            }
            if(item.getName().equals("Conjured Mana Cake")){
                assertThat(item.getSellIn(), is(-8));
                assertThat(item.getQuality(), is(0));
            }

        }

        for(int i=0; i< 40; i++){
            updateQuality();

        }

        for (Item item:items) {
            if(item.getName().equals("+5 Dexterity Vest")) {
                assertThat(item.getSellIn(), is(-41));
                assertThat(item.getQuality(), is(0));
            }
            if(item.getName().equals("Aged Brie")){
                assertThat(item.getSellIn(), is(-49));
                assertThat(item.getQuality(), is(50));
            }
            if(item.getName().equals("Elixir of the Mongoose")){
                assertThat(item.getSellIn(), is(-46));
                assertThat(item.getQuality(), is(0));
            }
            if(item.getName().equals("Sulfuras, Hand of Ragnaros")){
                assertThat(item.getSellIn(), is(0));
                assertThat(item.getQuality(), is(80));
            }
            if(item.getName().equals("Backstage passes to a TAFKAL80ETC concert")){
                assertThat(item.getSellIn(), is(-36));
                assertThat(item.getQuality(), is(0));
            }
            if(item.getName().equals("Conjured Mana Cake")){
                assertThat(item.getSellIn(), is(-48));
                assertThat(item.getQuality(), is(0));
            }
        }
}
	
    public static void updateQuality()
    {
        for (Item item : items) {
            item.updateItem();
        }
    }

}