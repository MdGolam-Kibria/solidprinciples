package com.solid.solidprinciples.dip.solution;

import java.math.BigDecimal;

public class CreditCard implements BankCard{

    @Override
    public void doTransaction(BigDecimal amount) {
        System.out.println("Payment using credit card");
    }
}
