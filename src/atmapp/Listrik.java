package atmapp;
import java.util.*;
// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Listrik extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad

   // constant corresponding to menu option to cancel
   private final static int CANCELED = -100;

   // Withdrawal constructor
   public Listrik(int userAccountNumber, Screen atmScreen, 
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
       double availableBalance;
       Screen screen = super.getScreen();
       amount = displayMenuOfAmounts();
       if(amount != CANCELED){
                BankDatabase atmBankDatabase = super.getBankDatabase();
                availableBalance =
                        atmBankDatabase.getAvailableBalance(
                                super.getAccountNumber());
                if(amount <= availableBalance){
                    Account currentAccount = atmBankDatabase.getAccount(super.getAccountNumber());
                    BankStatement NewBankStatement = 
                                new BankStatement(currentAccount.getBankStatement().size() + 1,amount,0,currentAccount.getTotalBalance());
                    currentAccount.credit(amount,NewBankStatement);
                    screen.displayPaymentSuccess("Top UP PLN");
                    screen.displayPLNBill(amount);
                }
                else {
                    screen.displayNotEnoughBalance();
                    screen.displayDollarAmount(availableBalance);
                    screen.displayPLNBill(amount);
                }
       }
       else {
           screen.displayCancelingTransaction();
       }
   } 

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private int displayMenuOfAmounts() {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // array of amounts to correspond to menu numbers
      int[] amounts = {0, 10, 20, 50, 100, 200};

      // loop while no valid choice has been made
      while (userChoice == 0) {
         // display the withdrawal menu
         screen.displayListrik();

         int input = keypad.getInput(); // get user input through keypad

         // determine how to proceed based on the input value
         switch (input) {
            // if the user chose a withdrawal amount
            // (i.e., chose option 1, 2, 3, 4 or 5), return the
            // corresponding amount from amounts array
            
            // -- NAMBAH INI
            case 1: 
               userChoice = amounts[1]; // save user's choice
               break; 
            case 2: 
               userChoice = amounts[2]; // save user's choice
               break; 
            case 3: 
               userChoice = amounts[3]; // save user's choice
               break; 
            case 4:
               userChoice = amounts[4]; // save user's choice
               break;  
            case 5:
               userChoice = amounts[5]; // save user's choice
               break;       
            case 6: // the user chose to cancel
               userChoice = CANCELED; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               screen.displayInputError();
         } 
      } 

      return userChoice; // return withdrawal amount or CANCELED
   }
} 
