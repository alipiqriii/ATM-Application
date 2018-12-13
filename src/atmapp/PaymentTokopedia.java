package atmapp;
import java.util.*;

public class PaymentTokopedia extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private TokopediaDatabase tokopediaDatabase;

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 6;

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
       keypad.getInputString();
       String codeNumber = keypad.getInputString();// get user input through keypad      
       TransactionCode voucherTokopedia = tokopediaDatabase.getCode(codeNumber);

       if (voucherTokopedia != null ){
           double availableBalance = atmBankDatabase.getAvailableBalance(super.getAccountNumber());
           if (availableBalance >= voucherTokopedia.getPrice()){
               
                atmBankDatabase.getAccount(super.getAccountNumber()).
                            credit(voucherTokopedia.getPrice());
                
                atmBankDatabase.getAccount(5678).addAmount(voucherTokopedia.getPrice());
                  
                
                    screen.displaySucccessPaymentTokopedia();
           }
           else   screen.displayMessageLine("Your balance is not enough "
                        + "to make a buy voucher Tokopedia");           
       }
       else   screen.displayMessageLine("Canceling transaction...");         
           
   } 

} 