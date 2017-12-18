package com.refactor.nullobject.introduce;

public class SiteClient {

    public static void main(String[] args) {
        Site site = new Site();
        Customer customer = site.getCustomer();
        BillingPlan plan = customer.getPlan();
        String customerName = customer.getName();
        int weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
    }
}
