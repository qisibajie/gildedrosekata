package com.refactor.mini_project;

public class RegularPriceStrategy extends PriceStrategy {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    double getCharge(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount;
    }
}
