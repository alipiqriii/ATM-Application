package atmapp;
import java.util.*;
// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Ukt extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 9;

   // Withdrawal constructor
   public Ukt(int userAccountNumber, Screen atmScreen, 
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
       if(amount != 9){
                BankDatabase atmBankDatabase = super.getBankDatabase();
                availableBalance =
                        atmBankDatabase.getAvailableBalance(
                                super.getAccountNumber());
                if(amount <= availableBalance){
                    atmBankDatabase.getAccount(super.getAccountNumber()).
                            credit(amount);
                    screen.displayMessageLine("Pembayaran UKT Berhasil");
                }
                else {
                    screen.displayMessageLine("Saldo tidak memenuhi untuk pembayaran UKT");
                    screen.displayMessage("Balance : ");
                    screen.displayDollarAmount(availableBalance);
                    screen.displayMessageLine("");
                    screen.displayMessage("Amount UKT : ");
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
      int[] amounts = {0, 50, 100, 400, 550, 650, 750, 850, 950};

      // loop while no valid choice has been made
      while (userChoice == 0) {
         // display the withdrawal menu
         screen.displayMessageLine("\n Biaya Pendidikan DIII REKAYASA di POLBAN:");
         screen.displayMessageLine("1 - UKT Kel.1 $50");
         screen.displayMessageLine("2 - UKT Kel.2 $100");
         screen.displayMessageLine("3 - UKT Kel.3 $400");
         screen.displayMessageLine("4 - UKT Kel.4 $550");
         screen.displayMessageLine("5 - UKT Kel.5 $650");
         screen.displayMessageLine("6 - UKT Kel.6 $750");
         screen.displayMessageLine("7 - UKT Kel.7 $850");
         screen.displayMessageLine("8 - UKT Kel.8 $950");
         screen.displayMessageLine("9 - Cancel transaction");
         screen.displayMessage("\nChoose a UKT: ");

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
               userChoice = amounts[input]; // save user's choice
               break;
            case 7:
               userChoice = amounts[input]; // save user's choice
               break;   
            case 8:
               userChoice = amounts[input]; // save user's choice
               break;
            case CANCELED: // the user chose to cancel
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