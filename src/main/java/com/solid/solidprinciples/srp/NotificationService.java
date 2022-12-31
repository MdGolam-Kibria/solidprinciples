package com.solid.solidprinciples.srp;

public class NotificationService {
    public void sendOTP(String medium){
        if (medium.equalsIgnoreCase("email")){
            System.out.println("This is email notification");
        }
        if (medium.equalsIgnoreCase("mobile")){
            System.out.println("This is mobile notification");
        }
    }
}
