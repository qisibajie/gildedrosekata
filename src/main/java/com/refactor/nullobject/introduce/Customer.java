package com.refactor.nullobject.introduce;

public class Customer {
    private String name;
    private BillingPlan plan;
    private PaymentHistory history;

    public String getName(){
        return name;
    }

    public BillingPlan getPlan(){
        return  plan;
    }

    public PaymentHistory getHistory(){
        return  history;
    }

}
