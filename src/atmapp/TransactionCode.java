package atmapp;

import java.util.*;

public class TransactionCode {
   private String Code; // account number
   private double Price; //harga barang
   private boolean Status; //status pembayaran 

   // Account constructor initializes attributes
   TransactionCode(String newCode, double newPrice) { //constructor ga di public, biar ga terkesan method
      Code = newCode;
      Price = newPrice;
      Status = false;
       }

    /**
     * @return the Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(boolean Status) {
        this.Status = Status;
    }
 
}