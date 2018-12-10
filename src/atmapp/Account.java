package atmapp;
import java.util.*;
public class Account {
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double availableBalance; // funds available for withdrawal
   private double totalBalance; // funds available & pending deposits
   private boolean statusBlock;
   private int tryInvalidPIN;
   private ArrayList<BankStatement> bankStatement;

   // Account constructor initializes attributes
   public Account(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      // -- NAMBAH INI
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
      this.bankStatement = new ArrayList<BankStatement>();
      this.statusBlock = false;
   }

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN(int userPIN) {
      if (userPIN == pin && !statusBlock) {
         return true;
      }
      else  {
          if(!statusBlock){
              tryInvalidPIN += 1;
          }
         
         if(tryInvalidPIN == 3){
             statusBlock = true;
             tryInvalidPIN = 0;
         }
         return false;
      }
   } 

   // returns available balance
   public double getAvailableBalance() {
      return availableBalance;
   }
   
   // returns the total balance
   public double getTotalBalance() {
      return totalBalance;
   } 
   
   public void credit(double amount) {
       this.availableBalance -= amount;
       this.totalBalance -= amount;
   }

   public void debit(double amount) {
//       this.availableBalance += amount;
       this.totalBalance += amount;
   }
   
   public void addAmount(double amount) {
       this.availableBalance += amount;
       this.totalBalance += amount;
   }

   public int getAccountNumber() {
      return accountNumber;  
   }
   
   public void addRecordBankStatement(BankStatement newStatement){
       this.bankStatement.add(newStatement);
   }
   
   public void viewRecordBankStatement(){
       for(BankStatement key : this.bankStatement){
           System.out.print(""
                   + key.getNumberRecord()
                   + "\t"
                   + key.getDateRecord()
                   + "\t"
                   + key.getClockRecord()
                   + "\t$"
                   + key.getCreditRecord()
                   + "\t$"
                   + key.getDebitRecord()
                   + "\t$"
                   + key.getBalanceRecord()
                   + "\n");
       }
   }
   
   public ArrayList<BankStatement> getBankStatement(){
       return this.bankStatement;
   }
   public void setPin(int newPin){
       this.pin = newPin;
   }
   public void setStatusBlock(boolean newStatus){
       this.statusBlock  = newStatus;
   }
   public boolean getStatusBlock(){
       return this.statusBlock;
   }
}