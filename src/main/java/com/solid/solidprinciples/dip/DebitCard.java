package com.solid.solidprinciples.dip;

import java.math.BigDecimal;

public class DebitCard {
    public void doTransaction(BigDecimal amount){
        System.out.println("Payment using debit card");
    }
}
