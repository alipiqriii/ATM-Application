package atmapp;
import java.util.*;
// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Credit extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   // constant corresponding to menu option to cancel
   private final static int CANCELED = -100;

   // Withdrawal constructor
   public Credit(int userAccountNumber, Screen atmScreen, 
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
                atmBankDatabase.getAccount(super.getAccountNumber()).getAvailableBalance();
                if(amount <= 0){
                    screen.displayNegative();
                }
                else if(amount <= availableBalance){
                    Account currentAccount = atmBankDatabase.getAccount(super.getAccountNumber());
                        BankStatement NewBankStatement = 
                                new BankStatement(currentAccount.getBankStatement().size() + 1,amount,0,currentAccount.getTotalBalance());
                    currentAccount.credit(amount,NewBankStatement);
                    screen.displayMessageLine("Your Credit Payment Has Been Purchased");
                    screen.displayMessageLine("Please Check Your Message!");
                }
                else {
                    screen.displayMessageLine("Your balance is not enough "
                        + "to make a buy Credit");
                    screen.displayMessage("Balance : ");
                    screen.displayDollarAmount(availableBalance);
                    screen.displayMessageLine("");
                    screen.displayMessage("Amount Credit : ");
                    screen.displayDollarAmount(amount);
                }
       }
       else {
           screen.displayMessageLine("Canceling transaction...");
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
         String no_hp;
         screen.displayMessageLine("============ CREDIT PAYMENT ===========");
         screen.displayMessage("Input Your Telephone Number : ");
         no_hp = keypad.getInputString();
         screen.displayMessageLine("============== CATEGORY  ==============");
         screen.displayMessageLine("1 - $20");
         screen.displayMessageLine("2 - $40");
         screen.displayMessageLine("3 - $60");
         screen.displayMessageLine("4 - $100");
         screen.displayMessageLine("5 - $200");
         screen.displayMessageLine("6 - Cancel transaction");
         screen.displayMessageLine("=======================================");
         screen.displayMessage("Your Choice : ");

         int input = keypad.getInput(); // get user input through keypad
         screen.displayMessageLine("=======================================");
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
            case 6: // the user chose to cancel
               userChoice = CANCELED; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               screen.displayMessageLine(
                  "\nInvalid selection. Try again.");
         } 
      } 

      return userChoice; // return withdrawal amount or CANCELED
   }
} 