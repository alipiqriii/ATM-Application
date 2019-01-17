package atmapp;
import java.util.*;

public class PaymentTokopedia extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private TokopediaDatabase tokopediaDatabase;

   // constant corresponding to menu option to cancel
   private final static int CANCELED = -100;

   // Withdrawal constructor
   public PaymentTokopedia(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, TokopediaDatabase atmTokopediaDatabase ) {

      // initialize superclass variables

       super(userAccountNumber, atmScreen, atmBankDatabase);
      
      // -- NAMBAH INI
      amount = 0;
      keypad = atmKeypad;
      tokopediaDatabase = atmTokopediaDatabase;
      
   }

   // perform transaction
   @Override
   public void execute() {
       Screen screen = super.getScreen();
       BankDatabase atmBankDatabase = super.getBankDatabase();
       screen.displayPaymentTokopedia();
       String codeNumber = keypad.getInputString();// get user input through keypad      
       TransactionCode voucherTokopedia = tokopediaDatabase.getCode(codeNumber);

       if (voucherTokopedia != null ){
           double availableBalance = atmBankDatabase.getAvailableBalance(super.getAccountNumber());
           if (availableBalance >= voucherTokopedia.getPrice()){
               
               Account currentAccount = atmBankDatabase.getAccount(super.getAccountNumber());
                    BankStatement NewBankStatement = 
                            new BankStatement(currentAccount.getBankStatement().size() + 1,amount,0,currentAccount.getTotalBalance());
                currentAccount.credit(voucherTokopedia.getPrice(),NewBankStatement);
               
               Account destinationAccount = atmBankDatabase.getAccount(5678);
               NewBankStatement = new BankStatement(currentAccount.getBankStatement().size() + 1,
                       0,amount,currentAccount.getTotalBalance());
                destinationAccount.addAmount(voucherTokopedia.getPrice(),NewBankStatement);
                  
                
                    screen.displaySucccessPaymentTokopedia();
           }
           else   screen.displayMessageLine("Your balance is not enough "
                        + "to make a buy voucher Tokopedia");           
       }
       else   screen.displayMessageLine("Voucher Not Found \n Canceling transaction...");         
           
   } 

} 