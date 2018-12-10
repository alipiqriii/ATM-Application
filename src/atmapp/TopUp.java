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
public class TopUp extends Transaction {

   private int amount; // amount to withdraw
   private final Keypad keypad; // reference to keypad
   

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 0;

    public TopUp(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        
        amount = 0;
        keypad = atmKeypad;
    }

  
   // perform transaction
 @Override
   @SuppressWarnings("empty-statement")
   public void execute() {
       Account destinationAccount=null;
       Account currentAccount;
       Screen screen = super.getScreen();
       
       currentAccount = super.getBankDatabase().getAccount(super.getAccountNumber());
       while (destinationAccount == null){
        destinationAccount = displayDestinationTransfer();

        amount = displayAmountTopUp();
         if(amount != 0){
             if(amount <= currentAccount.getAvailableBalance()){
                 currentAccount.credit(amount);
                 destinationAccount.addAmount(amount);
                 screen.displayMessageLine("TopUp Successfull...");
             }
             else screen.displayMessageLine("Balance is Insfulence");
         }
         else screen.displayMessageLine("Canceling Transaction...");
       }
   } 
   
   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private Account displayDestinationTransfer(){
       int chooseDestination;
       BankDatabase atmBankDatabase = super.getBankDatabase();
       Screen screen = getScreen();
       screen.displayMessageLine("Topup Menu");
       screen.displayMessageLine("- 1 OVO");
       screen.displayMessageLine("- 0 Back");
       screen.displayMessage("Input : ");
       chooseDestination = keypad.getInput();
       switch(chooseDestination){
           case 1 :
               return atmBankDatabase.getAccount(11000);
       }
       return null;
   }
   private int displayAmountTopUp() {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // display the prompt
      screen.displayMessage("\nPlease enter a amount TopUp in " + 
         "Dollars (or 0 to cancel): ");
      int input = keypad.getInput(); // receive input of deposit amount
      
      if (input == CANCELED) {
         return CANCELED;
      }
      else {
         return input ; // return dollar amount
      }
   }
}

