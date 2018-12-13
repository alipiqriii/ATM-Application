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
   private int input;
   private final AccountVirtualDatabase virtualDatabase = new AccountVirtualDatabase();

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

        amount = pilihanTopup();
         if(amount != 0){
             if(amount <= currentAccount.getAvailableBalance()){
                 currentAccount.credit(amount);
                 destinationAccount.addAmount(amount);
                 screen.displayTopUpSuccess();
             }
             else screen.displayBalanceisInsfluence();
         }
         else screen.displayCancelingTransaction();
       }
   } 
   
   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private Account displayDestinationTransfer(){
       
       BankDatabase atmBankDatabase = super.getBankDatabase();
       Screen screen = getScreen();
       screen.displayTopUpMenu();
       
//       switch(chooseDestination){
//           case 1 :
               return atmBankDatabase.getAccount(11000);
//                displayOVOMenu(); break;
//           case 0 :
//               screen.displayMenu();break;
               
//       }
//       return null;
   }
   private int pilihanTopup(){
       int chooseDestination;
       chooseDestination = keypad.getInput();
       switch(chooseDestination){
           case 1 :
//               return atmBankDatabase.getAccount(11000);
                displayOVOMenu(); break;
//           case 0 :
//               screen.displayMenu();break;
               
       }
       if (input == CANCELED) {
         return CANCELED;
      }
      else {
         return input ; // return dollar amount
      }
   }
   private int displayAmountTopUp() {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // display the prompt
      screen.displayAmountTopUp();
      int input = keypad.getInput(); // receive input of deposit amount
      
      if (input == CANCELED) {
         return CANCELED;
      }
      else {
         return input ; // return dollar amount
      }
   }
  private AccountVirtual promptForDetail(){
       boolean valid = false;
        
        Screen screen = super.getScreen();
        
        screen.displayMessage("Please add 0159 befofe your phone number");
        screen.displayMessage("\nPlease enter destination account number : ");
        String destinationPhoneNumber = keypad.getInputString();
            
        if(destinationPhoneNumber.startsWith("0159")) {
                screen.displayMessage("\nPlease enter a transfer amount in " + "CENTS : ");
                amount = keypad.getInput();
                amount = amount / 100;
          
                if(virtualDatabase.authenticateUser(destinationPhoneNumber.substring(5))){
                    if(super.getBankDatabase().getAvailableBalance(super.getAccountNumber()) > amount) {
                        valid = true;
                    }else{
                        screen.displayMessageLine("It's not enough balance");
                        //continue;
                    }
                }else{
                    screen.displayMessageLine("Invalid phone number destination.");
                    //continue;
                }
            }else {
                screen.displayMessage("Please add 0159 in your account number.");
                //continue;
            }
        screen.displayMessage("\nAre you sure for this transaction (1 to yes or 0 to cancel) : ");
        input = keypad.getInput();
        
        if (valid && input == CANCELED) {
            return null;
        } else if (input == 1) {
            return virtualDatabase.getAccount(destinationPhoneNumber.substring(5));
        }
        
        screen.displayMessageLine(
           "\nInvalid selection. Try again.");
        return null;     
        
  }
  private int displayOVOMenu(){
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // array of amounts to correspond to menu numbers
      int[] amounts = {0, 20, 40, 60, 100, 200};
      promptForDetail();
      screen.displayOVOMenu();
      // loop while no valid choice has been made
      while (userChoice == 0) {
         // display the withdrawal menu
//         screen.displayOVOMenu();
         input = keypad.getInput(); // get user input through keypad
         
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
//       return input;
        if (input == CANCELED) {
             return CANCELED;
        }
        else {
             return input ;
        }
    }
  
}

