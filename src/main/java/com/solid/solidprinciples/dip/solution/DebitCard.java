package com.solid.solidprinciples.dip.solution;

import java.math.BigDecimal;

public class DebitCard implements BankCard{

    @Override
    public void doTransaction(BigDecimal amount) {
        System.out.println("Payment using debit card");
    }
}
