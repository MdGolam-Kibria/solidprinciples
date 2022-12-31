package com.solid.solidprinciples.dip;

import java.math.BigDecimal;

public class ShoppingMall {
    private DebitCard debitCard;

    public ShoppingMall(DebitCard debitCard) {
        this.debitCard = debitCard;
    }
    public void doPurchageSomething(BigDecimal amount){
        debitCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard();
        ShoppingMall shoppingMall =  new ShoppingMall(debitCard);
        shoppingMall.doPurchageSomething(BigDecimal.valueOf(12342.0));
        /**You can see here if we wanna do transaction using credit card we need to change the code
         * because this case tightly coupled with [DebitCard] .....\n
         * that will violate the dependency inversion principle [DSI] concept
         * as per the [DSI] concept we always need to maintain the Loosely coupled between the class
         *
         * So how we solve this problem ?
         * Solution: Follow the [solution] package.
         * */
    }
}
