package atmapp;
import java.util.*;
// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Transfer extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 0;

   // Withdrawal constructor
   public Transfer(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad) {

      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      
      // -- NAMBAH INI
      amount = 0;
      keypad = atmKeypad;
      
   }

   // perform transaction
   @Override
   public void execute() {
       Account destinationAccount;
       Screen screen = super.getScreen();
       destinationAccount = displayDestinationTransfer();
       double availableBalance = super.getBankDatabase().getAvailableBalance(super.getAccountNumber());
       
       if(destinationAccount != null){
           amount = displayAmountTransfer();
           if(amount != 0){
               if(amount <= super.getBankDatabase().getAvailableBalance(super.getAccountNumber())){
//                   screen.displayMessageLine("Transfer Successfull...");
                    BankDatabase atmBankDatabase = super.getBankDatabase();
                    Account currentAccount = atmBankDatabase.getAccount(super.getAccountNumber());
                    
                    currentAccount.credit(amount);
                    
                    BankStatement NewBankStatement = 
                    new BankStatement(currentAccount.getBankStatement().size() + 1,amount,0,currentAccount.getTotalBalance());
                    currentAccount.addRecordBankStatement(NewBankStatement);
                    
                    destinationAccount.addAmount(amount);
                    NewBankStatement = 
                    new BankStatement(destinationAccount.getBankStatement().size() + 1,0,amount,destinationAccount.getTotalBalance());
                    currentAccount.addRecordBankStatement(NewBankStatement);
                    
                    double availableBalanceNow = currentAccount.getAvailableBalance();
                    screen.displayTransferSuccess(availableBalanceNow);
               }
               else screen.displayBalanceInsfulence("transfer", availableBalance, amount);
           }
           else screen.displayCancel();
       }
       else {
           screen.displayInvalidAccount();
           screen.displayCancel();
       }
       
       
   } 
   
   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private Account displayDestinationTransfer(){
       int destinationAccount;
       BankDatabase atmBankDatabase = super.getBankDatabase();
       Screen screen = getScreen();
       screen.displayDestinationTransfer();
       destinationAccount = keypad.getInput();
       if(atmBankDatabase.getAccount(destinationAccount) != null){
           return atmBankDatabase.getAccount(destinationAccount);
       }
       else return null;
   }
   private int displayAmountTransfer() {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // display the prompt
      screen.displayInsertAmount("transfer");
      int input = keypad.getInput(); // receive input of deposit amount
      
      // check whether the user canceled or entered a valid amount
      if (input == CANCELED) {
         return CANCELED;
      }
      else {
         return (int )input / 100; // return dollar amount
      }
   }
} 