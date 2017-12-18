package com.refactor.nullobject.introduce;

public class NullCustomer extends Customer {
    public boolean isNull(){
        return true;
    }

    public String getName(){
        return "occupant";
    }

    public BillingPlan getPlan() {
        return BillingPlan.basic();
    }

    public PaymentHistory getHistory() {
        return PaymentHistory.newNull();
    }
}
