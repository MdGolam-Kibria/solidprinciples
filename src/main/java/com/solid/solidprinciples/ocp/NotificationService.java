package com.solid.solidprinciples.ocp;

public interface NotificationService {
    void sendOTP();
    void sendTransactionReport(String medium);
}
