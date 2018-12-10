package atmapp;
import java.util.*;
public abstract class Screen {
   
   // display a message without a carriage return
   public void displayMessage(String message) {
      System.out.print(message); 
   } 

   // display a message with a carriage return
   public void displayMessageLine(String message) {
      System.out.println(message);   
   }
   
   // displays a dollar amount
   public void displayDollarAmount(double amount) {
      System.out.printf("$%,.2f", amount);   
   }
   
   public abstract void displayAmount(String currency,double amount);
   public abstract void displayWelcome();
   public abstract void displayThanksYou();
   public abstract void displayInputAccount();
   public abstract void displayInputPIN();
   public abstract void displayInvalidAccountPIN();
   public abstract void displayExitSystem();
   public abstract void displayInvalidSelection();
   public abstract void displayMenu();
   public abstract void displayRecordBankStatement();
   public abstract void displayBalanceInformation(double available, double total);
   public abstract void displayInsertAmount(String message);
   public abstract void displayInsertEnvelopeDeposit(double amount);
   public abstract void displayReceivedEnvelopeDeposit();
   public abstract void displayCancel();
   public abstract void displayTransferSuccess(double availableBalance);
   public abstract void displayBalanceInsfulence(String message,double available,double amount);
   public abstract void displayInvalidAccount();
   public abstract void displayDestinationTransfer();
   public abstract void displayTakeCash();
   public abstract void displayInvalidWithdrawal();
   public abstract void displayBillsInsfulence();
   public abstract void displayMenuWithdrawal();
   public abstract void displayMenuPayment();
   public abstract void displayMenuInternetCable();
   public abstract void displayPaymentSuccess(String Payment);
   
   public abstract String getID();
   
} 