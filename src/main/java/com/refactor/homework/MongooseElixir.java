package com.refactor.homework;

public class MongooseElixir extends Item {
    public MongooseElixir(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {

        setQuality(notLessThanZero(getQuality() - 1));


        setSellIn(getSellIn() - 1);


        if (getSellIn() < 0) {

            setQuality(notLessThanZero(getQuality() - 1));
        }


    }
}
