/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;
import java.text.SimpleDateFormat;  
import java.util.Date; 

/**
 *
 * @author Ali
 */
public class BankStatement {
    private int numberRecord;
    private String dateRecord;
    private String clockRecord;
    private double creditRecord;
    private double debitRecord;
    private double balanceRecord;
    
    BankStatement(int number, double credit, double debit, double balance){
        this.numberRecord = number;
        this.dateRecord = new SimpleDateFormat("dd/MM/yyyy")
                .format(new java.util.Date());
        this.clockRecord = new SimpleDateFormat("HH:mm:ss")
                .format(new java.util.Date());
        this.creditRecord = credit;
        this.debitRecord = debit;
        this.balanceRecord = balance;
    }
    
    public int getNumberRecord(){
        return this.numberRecord;
    }
    
    public String getDateRecord(){
        return this.dateRecord;
    }
    
    public double getCreditRecord(){
        return this.creditRecord;
    }
    
    public double getDebitRecord(){
        return this.debitRecord;
    }
    
    public double getBalanceRecord(){
        return this.balanceRecord;
    }
    
    public String getClockRecord(){
        return this.clockRecord;
    }
}
