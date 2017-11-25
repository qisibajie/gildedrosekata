package com.refactor.mini_project;

public class NewReleasePriceStrategy extends PriceStrategy {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
