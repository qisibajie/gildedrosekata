package com.refactor.nullobject.introduce;

public class Customer {
    private String name;
    private BillingPlan plan;
    private PaymentHistory history;

    protected Customer() {

    }

    public String getName() {
        return name;
    }

    public BillingPlan getPlan() {
        return plan;
    }

    public PaymentHistory getHistory() {
        return history;
    }

    public boolean isNull() {
        return false;
    }

    static Customer newNull(){
        return  new NullCustomer();
    }

}
