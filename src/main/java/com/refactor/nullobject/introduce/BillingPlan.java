package com.refactor.nullobject.introduce;

public class BillingPlan {
    public static BillingPlan basic() {
        return new BillingPlan();
    }
}
