package atmapp;
import java.util.*;
// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Voucher_Game extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   // constant corresponding to menu option to cancel
   private final static int CANCELED = 6;

   // Withdrawal constructor
   public Voucher_Game(int userAccountNumber, Screen atmScreen, 
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
       if(amount != 0){
        BankDatabase atmBankDatabase = super.getBankDatabase();
        availableBalance =
                atmBankDatabase.getAccount(super.getAccountNumber()).getAvailableBalance();
                if(amount <= availableBalance){
                    atmBankDatabase.getAccount(super.getAccountNumber()).
                            credit(amount);
                    screen.displayMessageLine("Your Voucher Game Payment Has Been Purchased");
                    screen.displayMessageLine("Please Check Your Email!");
                }
                else {
                    screen.displayMessageLine("Your balance is not enough "
                        + "to make a buy voucher game");
                    screen.displayMessage("Balance : ");
                    screen.displayDollarAmount(availableBalance);
                    screen.displayMessageLine("");
                    screen.displayMessage("Amount voucher game : ");
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
         String email;
         screen.displayMessageLine("============ VOUCHER GAME =============");
         screen.displayMessage("Input Your Email Account Game : ");
         keypad.getInputString();
         email = keypad.getInputString();
//         keypad.getInput();
         screen.displayMessageLine("============== CATEGORY ===============");
         screen.displayMessageLine("1 - 10 points [$20]");
         screen.displayMessageLine("2 - 25 points [$40]");
         screen.displayMessageLine("3 - 40 points [$60]");
         screen.displayMessageLine("4 - 75 points [$100]");
         screen.displayMessageLine("5 - 180 points [$200]");
         screen.displayMessageLine("6 - Back");
         screen.displayMessageLine("========================================");
         screen.displayMessage("Your Choice : ");

         int input = keypad.getInput(); // get user input through keypad
         screen.displayMessageLine("====================================");
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
            case CANCELED: // the user chose to cancel
               userChoice = amounts[input - CANCELED]; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               screen.displayMessageLine(
                  "\nInvalid selection. Try again.");
         } 
      } 

      return userChoice; // return withdrawal amount or CANCELED
   }
} 