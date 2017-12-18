package com.refactor.nullobject.introduce;

public class NullPaymentHistory extends PaymentHistory {
    int getWeeksDelinquentInLastYear() {
        return 0;
    }
}
