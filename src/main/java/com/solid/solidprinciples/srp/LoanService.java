package com.solid.solidprinciples.srp;

public class LoanService {
    private void getLoanInterestInfo(String loanType){
        if (loanType.equalsIgnoreCase("HomeLoan")){
            System.out.println("This is homeLoan info");
        }
        if (loanType.equalsIgnoreCase("personalLoan")){
            System.out.println("This is personal loan info");
        }
        if (loanType.equalsIgnoreCase("car")){
            System.out.println("This is car loan info");
        }
    }
}
