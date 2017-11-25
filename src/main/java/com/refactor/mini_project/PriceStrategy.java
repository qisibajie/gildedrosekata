package com.refactor.mini_project;

public abstract class PriceStrategy {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);

    public static PriceStrategy newInstance(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                return new RegularPriceStrategy();
            case Movie.NEW_RELEASE:
                return new NewReleasePriceStrategy();
            case Movie.CHILDREN:
                return new ChildrenPriceStrategy();
            default:
                return null;
        }
    }
}
