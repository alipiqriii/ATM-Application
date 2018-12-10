package atmapp;
import java.util.*;

public class ATM {
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private DepositSlot depositSlot;
   private BankDatabase bankDatabase; // account information database

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int TRANSFER = 4;
   private static final int BANKSTATEMENT = 5;
   private static final int PAYMENT = 6;
   private static final int CHANGEPIN = 7;
   
   private static final int VOUCHERGAME     = 1;
   private static final int CREDIT          = 2;
   private static final int INTERNETCABLE   = 3;
   private static final int TOPUP = 5;
   private static final int UKT = 6;
   private static final int LISTRIK = 7;
   
   private static final int EXIT = 0;
   

   // no-argument ATM constructor initializes instance variables
   public ATM(Screen newScreen, Keypad newKeypad) {
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 0; // no current account number to start
      screen = newScreen; // create screen
      keypad = newKeypad; // create keypad 
      cashDispenser = new CashDispenser(); // create cash dispenser
      bankDatabase = new BankDatabase(); // create acct info database
      depositSlot = new DepositSlot();
   }
   
   public void setScreen(Screen newScreen){
       this.screen = newScreen;
   }

   // start ATM 
   public void run() {
      // welcome and authenticate user; perform transactions
//      while (true) {
         // loop while user is not yet authenticated
         while (!userAuthenticated) {
            screen.displayWelcome();
            authenticateUser(); // authenticate user
         }
         
         performTransactions(); // user is now authenticated
         userAuthenticated = false; // reset before next ATM session
         currentAccountNumber = 0; // reset before next ATM session
         screen.displayThanksYou();
//      }
   }

   // attempts to authenticate user against database
   private void authenticateUser() {
      screen.displayInputAccount();
      int accountNumber = keypad.getInput(); // input account number
      screen.displayInputPIN(); // prompt for PIN
      int pin = keypad.getInput(); // input PIN
      
      // set userAuthenticated to boolean value returned by database
      userAuthenticated = 
         bankDatabase.authenticateUser(accountNumber, pin);
      
      
      // check whether authentication succeeded
      if (userAuthenticated) {
         currentAccountNumber = accountNumber; // save user's account #
      } 
      else {
         if(bankDatabase.getAccount(accountNumber).getStatusBlock())
             screen.displayMessageLine("Account Has Been Blocked\n");
         else screen.displayInvalidAccountPIN();
      } 
   } 

   // display the main menu and perform transactions
   private void performTransactions() {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while (!userExited) {
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch (mainMenuSelection) {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY:         

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction(mainMenuSelection);
               currentTransaction.execute();
               bankDatabase.getAccount(currentAccountNumber).viewRecordBankStatement();
                break;
               
            case WITHDRAWAL:
                currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute(); // execute transaction
               break;
            case DEPOSIT:
                currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute(); // execute transaction
            break;
                
            case TRANSFER:
                currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute(); // execute transaction
            break;
                
            case BANKSTATEMENT:
                screen.displayRecordBankStatement();
                bankDatabase.getAccount(currentAccountNumber).viewRecordBankStatement();
            break;
                
            case PAYMENT:
                int choosenPayment=PAYMENT;
                currentTransaction = null;
                
                while (currentTransaction == null && choosenPayment != 0){
                screen.displayMenuPayment();
                choosenPayment = keypad.getInput();
                
                currentTransaction = createTransaction(PAYMENT+choosenPayment);
                if(currentTransaction != null) currentTransaction.execute();
                else if(choosenPayment != EXIT && currentTransaction==null)
                    screen.displayInvalidSelection();
                }
            break;
                
            case CHANGEPIN:
                int newPIN;
                screen.displayMessage("New PIN (0) to Cancel : ");
                newPIN = keypad.getInput();
                if(newPIN != 0)
                bankDatabase.getAccount(currentAccountNumber).setPin(newPIN);
            break;
                
            case EXIT: // user chose to terminate session
               screen.displayExitSystem();
               userExited = true; // this ATM session should end
               break;
             
            default: // 
               screen.displayInvalidSelection();
               break;
         }
      } 
   } 

   // display the main menu and return an input selection
   private int displayMainMenu() {
      screen.displayMenu();
      return keypad.getInput(); // return user's selection
   } 
         
   private Transaction createTransaction(int type) {
      Transaction temp = null; 
          
      switch (type) {
         case BALANCE_INQUIRY: 
            temp = new BalanceInquiry(
               currentAccountNumber, screen, bankDatabase);
            break;
         // -- NAMBAH INI
         case WITHDRAWAL:
             temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, 
                     keypad, cashDispenser);
             break;
         case DEPOSIT:
             temp = new Deposit(currentAccountNumber,screen,bankDatabase,keypad,depositSlot);
             break;
         case TRANSFER:
             temp = new Transfer(currentAccountNumber,screen,bankDatabase,keypad);
             break;
         case PAYMENT+VOUCHERGAME:
             temp = new Voucher_Game(currentAccountNumber,screen,bankDatabase,keypad);
             break;
         case PAYMENT+INTERNETCABLE:
             temp = new InternetCable(currentAccountNumber,screen,bankDatabase,keypad);
             break;
         case PAYMENT+CREDIT:
             temp = new Credit(currentAccountNumber,screen,bankDatabase,keypad);
             break;
         case PAYMENT+TOPUP:
             temp = new TopUp(currentAccountNumber, screen, bankDatabase, keypad);
             break;
         case PAYMENT+UKT:
             temp = new Ukt(currentAccountNumber, screen, bankDatabase, keypad);
             break;
         case PAYMENT+LISTRIK:
             temp = new Listrik(currentAccountNumber, screen, bankDatabase, keypad);
             break;
          
      }

      return temp;
   } 
}