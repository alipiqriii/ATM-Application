package atmapp;
import java.util.*;

public class ATMApp {
   // main method creates and runs the ATM
   public static void main(String[] args) {
      Keypad keypad = new Keypad();
      ATM theATM=null;
      Screen screenID = new ScreenID();
      Screen screenEN = new ScreenEN();
      int choosenLanguage;
      while (true) {
        System.out.println("Pilih Bahasa : ");
        System.out.println("1. Indonesia");
        System.out.println("2. English");
        System.out.print("Pilihan : ");
        choosenLanguage = keypad.getInput();
        switch(choosenLanguage){
            case 1 :
                if(theATM == null) theATM = new ATM(screenID,keypad);
                else theATM.setScreen(screenID);
                theATM.run();
                break;
            case 2 : 
                if(theATM == null) theATM = new ATM(screenEN,keypad);
                else theATM.setScreen(screenEN);
                theATM.run();
                break;
        }
      }
      
   }
} 