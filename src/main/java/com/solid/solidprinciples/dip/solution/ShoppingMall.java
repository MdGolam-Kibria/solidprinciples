package com.solid.solidprinciples.dip.solution;

import java.math.BigDecimal;

public class ShoppingMall {
    private BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }
    public void doPurchageSomething(BigDecimal amount){
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        /**Using debit card*/
        BankCard bankCard = new DebitCard();
        ShoppingMall shoppingMall =  new ShoppingMall(bankCard);
        shoppingMall.doPurchageSomething(BigDecimal.valueOf(53345.0));
        /**Using credit card*/
        BankCard bankCar = new CreditCard();
        ShoppingMall shoppingMal =  new ShoppingMall(bankCar);
        shoppingMal.doPurchageSomething(BigDecimal.valueOf(234243.5));
    }
}
