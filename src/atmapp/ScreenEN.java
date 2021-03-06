package atmapp;
import java.util.*;
public class ScreenEN extends Screen {
   
   String ID = "EN";
   
   @Override
   public void displayAmount(String currency,double amount){
       System.out.printf(currency+"%,.2f", amount);
   }
   @Override
   public void displayWelcome(){
       displayMessageLine("\nWelcome!");
   }
   @Override
   public void displayThanksYou(){
       displayMessageLine("\nThank you! Goodbye!");
   }
   @Override
   public void displayInputAccount(){
       displayMessage("\nPlease enter your account number: ");
   }
   @Override
   public void displayInputPIN(){
       displayMessage("\nEnter your PIN: ");
   }
   @Override
   public void displayInvalidAccountPIN(){
       displayMessageLine("Invalid account number or PIN. Please try again.");
   }
   @Override
   public void displayExitSystem(){
       displayMessageLine("\nExiting the system...");
   }
   @Override
   public void displayInvalidSelection(){
       displayMessageLine("\nYou did not enter a valid selection. Try again.");
   }
   @Override
   public void displayMenu(){
        displayMessageLine("\nMain menu:");
        displayMessageLine("1 - View my balance");
        displayMessageLine("2 - Withdraw cash");
        displayMessageLine("3 - Deposit funds");
        displayMessageLine("4 - Transfer");
        displayMessageLine("5 - Bank Statement");
        displayMessageLine("6 - Payment");
        displayMessageLine("7 - Change PIN");
        displayMessageLine("0 - Exit\n");
        displayMessage("Enter a choice: ");
   }
   @Override
   public void displayRecordBankStatement(){
       displayMessage("");
       displayMessage("Number\tDate\t\tClock\t\tCredit\tDebit\tBalance");
   }
   @Override
   public void displayBalanceInformation(double available, double total){
        displayMessageLine("\nBalance Information:");
        displayMessage(" - Available balance: "); 
        displayAmount("$",available);
        displayMessage("\n - Total balance:     ");
        displayAmount("$",total);
        displayMessageLine("");
   }
   @Override
   public void displayInsertAmount(String message){
        displayMessage("\nPlease enter a"+message+" amount in " + 
         "CENTS (or 0 to cancel): ");
   }
   @Override
   public void displayInsertEnvelopeDeposit(double amount){
        displayMessage("Please insert a deposit "
                   + "envelope containing ");
        displayAmount("$",amount);
        displayMessageLine("");
   }
   @Override
   public void displayReceivedEnvelopeDeposit(){
       displayMessageLine("Your envelope has been received.\n" 
         + "NOTE: The money just deposited will not be available "
         + "until we verify "
         + "the amount of any enclosed cash and "
         + "your checks clear.");
   }
   @Override
   public void displayCancel(){
       displayMessageLine("Canceling transaction...");
   }
   @Override
   public void displayTransferSuccess(double availableBalance){
        displayMessageLine("Transfer Successfull...");
        displayMessageLine("Your Balance Now : ");
        displayAmount("$",availableBalance);
   }
   @Override
   public void displayBalanceInsfulence(String message,double available,double amount){
        displayMessageLine("Your balance is not enough "
            + "to make a"+ message);
        displayMessage("Balance : ");
        displayDollarAmount(available);
        displayMessageLine("");
        displayMessage("Amount "+message+" : ");
        displayDollarAmount(amount);
   }
   @Override
   public void displayInvalidAccount(){
       displayMessageLine("Account Number Not Found");
   }
   @Override
   public void displayDestinationTransfer(){
       displayMessage("Insert Destination Account For Transfer : ");
   }
   @Override
   public void displayTakeCash(){
       displayMessageLine("Your cash has been dispensed. "
                                + "Please take your cash now.");
   }
   @Override
   public void displayInvalidWithdrawal(){
       displayMessageLine("your withdrawal amount not valid.");
       displayMessageLine("only valid for multiples of 20 dollars");
   }
   @Override
   public void displayBillsInsfulence(){
       displayMessageLine("Bills is insufficient in cash dispensers");
   }
   @Override
   public void displayMenuWithdrawal(){
        displayMessageLine("\nWithdrawal Menu:");
        displayMessageLine("1 - $20");
        displayMessageLine("2 - $40");
        displayMessageLine("3 - $60");
        displayMessageLine("4 - $100");
        displayMessageLine("5 - $200");
        displayMessageLine("6 - Other amount");
        displayMessageLine("7 - Cancel transaction");
        displayMessage("\nChoose a withdrawal amount: ");
   }
   
   @Override
   public void displayMenuInternetCable(){
        displayMessageLine("\nIndihome Internet Cable Menu:");
        displayMessageLine("1 - 10MbPS/Month ($75)");
        displayMessageLine("2 - 15MbPS/Month ($100)");
        displayMessageLine("3 - 25MbPS/Month ($150)");
        displayMessageLine("4 - 50MbPS/Month ($250)");
        displayMessageLine("0 - Back");
        displayMessage("\nInput : ");
   }
   
   @Override
   public void displayMenuTvSatelite(){
        displayMessageLine("\nMenu TV Satelite Indovision:");
        displayMessageLine("1 - 10MbPS/Bulan ($75)");
        displayMessageLine("2 - 15MbPS/Bulan ($100)");
        displayMessageLine("3 - 25MbPS/Bulan ($150)");
        displayMessageLine("4 - 50MbPS/Bulan ($250)");
        displayMessageLine("0 - Kembali");
        displayMessage("\nInput : ");
   }
   
   @Override
   public void displayMenuPayment(){
        displayMessageLine("\nPayment Menu:");
        displayMessageLine("1 - Voucher Game");
        displayMessageLine("2 - Credit");
        displayMessageLine("3 - Indihome Internet Cable");
        displayMessageLine("4 - Indovision Satelite TV");
        displayMessageLine("5 - TopUp");
        displayMessageLine("6 - UKT");
        displayMessageLine("7 - PLN");
        displayMessageLine("8 - Tokopedia");
        displayMessageLine("0 - Back");
        displayMessage("\nInput: ");
   }
   
   @Override
   public void displayPaymentSuccess(String Payment){
       displayMessageLine(Payment + " Successfully");
   }
   
   @Override
   public String getID(){
       return this.ID;
   }
   @Override
   public void displayTopUpSuccess(){
       displayMessageLine("TopUp Successfull...");
   }
   
   @Override
    public void displayBalanceisInsfluence(){
        displayMessageLine("Balance is Insfulence");
    }
   
    @Override
    public void displayCancelingTransaction(){
        displayMessageLine("Canceling Transaction...");
    }
    
    @Override
    public void displayTopUpMenu(){
        displayMessageLine("Topup Menu");
        displayMessageLine("- 1 OVO");
        displayMessageLine("- 0 Back");
        displayMessage("Input menu: ");
    }
    
   @Override
    public void displayOVOMenu(){
        displayMessageLine("\nTopUp Menu:");
        displayMessageLine("1 - $20");
        displayMessageLine("2 - $40");
        displayMessageLine("3 - $60");
        displayMessageLine("4 - $100");
        displayMessageLine("5 - $200");
        displayMessageLine("6 - Cancel transaction");
        displayMessage("\nChoose a TopUp amount: ");

         
     }
    
    
    
    @Override
    public void displayAmountTopUp(){
        displayMessage("\nPlease enter a amount TopUp in " + 
         "Dollars (or 0 to cancel): ");
    }
    
    @Override
    public void displayinfo(){
            displayMessage("Please add 0159 befofe your phone number");
    }
    
    @Override
    public void displayInputNumber(){
        displayMessage("\nPlease enter destination account number : ");
    }
    
    @Override 
    public void displayTransfer(){
        displayMessage("\nPlease enter a transfer amount in " + "CENTS : ");
    }
    
    @Override 
    public void displaySaldo(){
        displayMessageLine("It's not enough balance");
    }
    
    @Override 
    public void displayInformation(){
        displayMessage("Please add 0159 in your account number.");
    }
    
    @Override
    public void displayQuetion(){ 
        displayMessage("\nAre you sure for this transaction (1 to yes or 0 to cancel) : ");
    }
    
    @Override
    public void displayTryAgain(){ 
        displayMessageLine("\nInvalid selection. Try again.");
    }
        
    @Override 
    public void displayInvalid(){
        displayMessageLine("Invalid phone number destination.");
    }
    
    
    @Override
    public void displayPaymentTokopedia(){
        displayMessageLine ("==== Payment Tokopedia ====");
        displayMessage ("Input Order Code : ");
    }
    
    @Override
    public void displaySucccessPaymentTokopedia(){
        displayMessageLine ("Your Payment Tokopedia Has Success");
    }
    

    public void displayListrik(){
        displayMessage("\n=== Top Up PLN ===");
        displayMessageLine("1 - $10");
        displayMessageLine("2 - $20");
        displayMessageLine("3 - $50");
        displayMessageLine("4 - $100");
        displayMessageLine("5 - $200");
        displayMessageLine("6 - Cancel transaction");
        displayMessage("\nChoose a TopUp amount: ");
    }
    
    @Override
    public void displayInputError(){
        displayMessage("\nWrong PLN number. Please try again.\n");
    }
    
    @Override
    public void displayNotEnoughBalance(){
        displayMessageLine("Your balance is not enough "
        + "to make the payment.");
        displayMessage("Balance : ");
    }
    
    @Override
    public void displayPLNBill(int amount){
        displayMessageLine("");
        displayMessage("The amount of the bill : " + amount);
    }
    
    @Override
    public void displayNegative(){
        displayMessageLine("Number Cannot Negative");
    }
}