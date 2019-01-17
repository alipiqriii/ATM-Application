package atmapp;
import java.util.*;
// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction {
   String withdrawal;
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private CashDispenser cashDispenser; // reference to cash dispenser

   // constant corresponding to menu option to cancel
   private final static int CANCELED = -100;

   // Withdrawal constructor
   public Withdrawal(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      CashDispenser atmCashDispenser) {

      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      
      // -- NAMBAH INI
      amount = 0;
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
      
   }

   // perform transaction
   @Override
   public void execute() {
       
       if(super.getScreen().getID() == "ID") withdrawal = "Penarikan";
       else withdrawal = "Withdrawal";
       double availableBalance;
       Screen screen = super.getScreen();
       
       amount = displayMenuOfAmounts();
       if(amount != CANCELED){
            if(cashDispenser.isSufficientCashAvailable(amount)){
                BankDatabase atmBankDatabase = super.getBankDatabase();
                availableBalance =
                        atmBankDatabase.getAvailableBalance(
                                super.getAccountNumber());
                if(amount <= 0){
                    screen.displayNegative();
                    screen.displayCancel();
                }
                else if(amount <= availableBalance){
                    if(amount % 20 == 0){
                        Account currentAccount = atmBankDatabase.getAccount(super.getAccountNumber());
                        cashDispenser.dispenseCash(amount);
                        BankStatement NewBankStatement = 
                                new BankStatement(currentAccount.getBankStatement().size() + 1,amount,0,currentAccount.getTotalBalance());
                        atmBankDatabase.getAccount(super.getAccountNumber()).
                                credit(amount,NewBankStatement);
                        screen.displayTakeCash();
                        
                    }
                    else {
                    screen.displayInvalidWithdrawal();
                    screen.displayCancel();
                    }
                    
                }
                else {
                    screen.displayBalanceInsfulence(withdrawal, availableBalance, amount);
                }
            }
            else {
                screen.displayBillsInsfulence();
            }
       }
       else {
           screen.displayCancel();
       }
   } 

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private int displayMenuOfAmounts() {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // array of amounts to correspond to menu numbers
      int[] amounts = {0, 20, 40, 60, 100, 200};

      // loop while no valid choice has been made
      while (userChoice == 0) {
         // display the withdrawal menu
         screen.displayMenuWithdrawal();

         int input = keypad.getInput(); // get user input through keypad

         // determine how to proceed based on the input value
         switch (input) {
            // if the user chose a withdrawal amount
            // (i.e., chose option 1, 2, 3, 4 or 5), return the
            // corresponding amount from amounts array
            
            // -- NAMBAH INI
            case 1: 
               userChoice = amounts[input]; // save user's choice
               break; 
            case 2: 
               userChoice = amounts[input]; // save user's choice
               break; 
            case 3: 
               userChoice = amounts[input]; // save user's choice
               break; 
            case 4:
               userChoice = amounts[input]; // save user's choice
               break;  
            case 5:
               userChoice = amounts[input]; // save user's choice
               break;
            case 6:
                screen.displayInsertAmount(withdrawal);
                userChoice = keypad.getInput();
                if (userChoice == 0){
                    userChoice = CANCELED;
                }
                break;
            case 7: // the user chose to cancel
               userChoice = CANCELED; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               screen.displayInvalidSelection();
         } 
      } 

      return userChoice; // return withdrawal amount or CANCELED
   }
} 