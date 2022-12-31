package com.solid.solidprinciples.isp;

public class PayATM implements UPIPayment {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {
        /**This feature is not available in this platform
         * As we know [[We should not force the client to use the methods that they don't wanna use]]
         * So here this platform[PayATM] force to implement this [getCashBackAsCreditBalance()] method that actually not need here....
         * So we can say this process not follow the ISP [Interface Segregation Principle]
         * */
    }
}
