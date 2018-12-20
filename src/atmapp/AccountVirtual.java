/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;

/**
 *
 * @author Sheilla
 */
public class AccountVirtual {
     //private int accountNumber; //account number
    private String phoneNumber; //phone number
    private double saldo; //funds available
    
    public AccountVirtual(String thePhoneNumber, double theSaldo) {
        //accountNumber = theAccountNumber;
        phoneNumber = thePhoneNumber;
        saldo = theSaldo;
    }
    
    public double getAvailableSaldo() {
        return saldo;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void topUpSaldo(double amount){
        this.saldo += amount;
    }
}

