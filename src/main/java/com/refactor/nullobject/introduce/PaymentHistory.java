package com.refactor.nullobject.introduce;

public class PaymentHistory {
    private int weeksDelinquentInLastYear;

    int getWeeksDelinquentInLastYear() {
        return weeksDelinquentInLastYear;
    }

    static PaymentHistory newNull() {
        return new NullPaymentHistory();
    }
}
