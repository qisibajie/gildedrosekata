package com.refactor.nullobject.introduce;

public class Site {
    Customer customer;

    Customer getCustomer() {
        return customer == null ? Customer.newNull() : customer;
    }
}
