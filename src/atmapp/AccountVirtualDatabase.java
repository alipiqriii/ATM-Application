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
public class AccountVirtualDatabase {
        private AccountVirtual[] accountVirtual; //array of Accounts virtual
    
    public AccountVirtualDatabase () {
        accountVirtual = new AccountVirtual[2];
        accountVirtual[0] = new AccountVirtual("08951611126", 1000.0);
        accountVirtual[1] = new AccountVirtual("08123456789",1500.0);
    }
    
    private AccountVirtual getNumber(String phoneNumber) {
        for(AccountVirtual indeks : accountVirtual){
            if(indeks.getPhoneNumber().equals(phoneNumber)) return indeks;
        }
        return null;
//        return accountVirtual[0].getPhoneNumber() == phoneNumber?accountVirtual[0]:
//              accountVirtual[1].getPhoneNumber() == phoneNumber?accountVirtual[1]:null;
    }
    
    public boolean authenticateUser(String phoneNumber) {
       AccountVirtual userAccount = getNumber(phoneNumber);
       
       if(userAccount != null) {
           return true;
       }else {
           return false;
       }
    }
    
    public AccountVirtual getAccount(String phoneNumber) {
        AccountVirtual userAccount = getNumber(phoneNumber);
       
       if(userAccount != null) {
           return getNumber(phoneNumber);
       }else {
           return null;
       }
    }

}
