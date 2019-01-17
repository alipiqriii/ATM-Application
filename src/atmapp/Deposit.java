package atmapp;
import java.util.*;
public class Deposit extends Transaction {
   private double amount; // amount to deposit
   private Keypad keypad; // reference to keypad
   private DepositSlot depositSlot; // reference to deposit slot
   private final static int CANCELED = -100; // constant for cancel option

   // Deposit constructor
   public Deposit(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot) {
      
      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      // -- NAMBAH INI
      depositSlot = atmDepositSlot;
      keypad = atmKeypad;
      amount = 0;

   } 

   // perform transaction
   @Override
   public void execute() {
       
       
       Screen screen = getScreen();
       amount = promptForDepositAmount();
       if(amount != CANCELED){
           BankDatabase atmBankDatabase = super.getBankDatabase();
           screen.displayInsertEnvelopeDeposit(amount);
           if(depositSlot.isEnvelopeReceived()){
               Account currentAccount = atmBankDatabase.getAccount(super.getAccountNumber());
               screen.displayReceivedEnvelopeDeposit();
               BankStatement NewBankStatement = 
               new BankStatement(currentAccount.getBankStatement().size() + 1,0,amount,currentAccount.getTotalBalance());
               currentAccount.debit(amount,NewBankStatement);
               
           }
       }
       else {
           screen.displayCancel();
       }
   }

   // prompt user to enter a deposit amount in cents 
   private double promptForDepositAmount() {
       
      Screen screen = getScreen(); // get reference to screen
      String deposit;
       if(screen.getID() == "ID") deposit = "Setor";
       else deposit = "Deposit";
      // display the prompt
      screen.displayInsertAmount(deposit);
      int input = keypad.getInput(); // receive input of deposit amount
      
      // check whether the user canceled or entered a valid amount
      if(input <= 0){
         screen.displayNegative();
         return CANCELED;
      }
      else if (input == 0) {
         return CANCELED;
      }
      else {
         return (double) input / 100; // return dollar amount
      }
   }
} 
