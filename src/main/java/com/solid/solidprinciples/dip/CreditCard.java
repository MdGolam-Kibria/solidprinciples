package com.solid.solidprinciples.dip;

import java.math.BigDecimal;

public class CreditCard {
    public void doTransaction(BigDecimal amount) {
        System.out.println("Payment using credit card");
    }
}
