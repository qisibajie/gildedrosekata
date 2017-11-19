package com.refactor.homework;

public class Item {
    public String name;
	public int sellIn; 
    public int quality; 
    
    public Item(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	public void updateItem() {
        if ((!"Aged Brie".equals(getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(getName())) {
            if (getQuality() > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
                    setQuality(getQuality() - 1);
                }
            }
        } else {
            if (getQuality() < 50) {
                setQuality(getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(getName())) {
                    if (getSellIn() < 11) {
                        if (getQuality() < 50) {
                            setQuality(getQuality() + 1);
                        }
                    }

                    if (getSellIn() < 6) {
                        if (getQuality() < 50) {
                            setQuality(getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
            setSellIn(getSellIn() - 1);
        }

        if (getSellIn() < 0) {
            if (!"Aged Brie".equals(getName())) {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(getName())) {
                    if (getQuality() > 0) {
                        if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
                            setQuality(getQuality() - 1);
                        }
                    }
                } else {
                    setQuality(getQuality() - getQuality());
                }
            } else {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }
        }
    }

	/* Generated getter and setter code */
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSellIn() {
		return sellIn;
	}
	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
}
