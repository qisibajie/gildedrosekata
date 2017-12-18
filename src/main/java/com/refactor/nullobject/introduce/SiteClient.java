package com.refactor.nullobject.introduce;

public class SiteClient {

    public static void main(String[] args) {
        Site site = new Site();
        Customer customer = site.getCustomer();
        BillingPlan plan = customer.getPlan();
        String customerName = customer.getName();
        int weeksDelinquent;
        if (customer.isNull()) {
            weeksDelinquent = 0;
        } else {
            weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
        }
    }
}
