package atmapp;

import java.util.*;

public class TokopediaDatabase {
   private TransactionCode[] transactionCodes ; // array of Accounts
   
   public TokopediaDatabase() {
      transactionCodes = new TransactionCode [4];
      
      transactionCodes[0] = new TransactionCode ("Qwert",100);
      transactionCodes[1] = new TransactionCode ("Yuiop",200); 
      transactionCodes[2] = new TransactionCode ("Asdf", 300);
      transactionCodes[3] = new TransactionCode ("Ghjkl",400);    
   }
   
   public TransactionCode getCode (String codeNumber){
       for (TransactionCode key : transactionCodes ){
           if (key.getCode().equals(codeNumber)) return key;
       }
       return null;
   }
   
   public double getCodePrice (String Code){
       return getCode(Code).getPrice();
   }
   
   public void setCodeStatus (String Code){
       getCode(Code).setStatus(true);
   }
}
   
