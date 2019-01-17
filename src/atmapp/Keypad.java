package atmapp;
import java.util.*;
import java.util.Scanner;

public class Keypad {
   private Scanner input; // reads data from the command line
                         
   public Keypad() {
      input = new Scanner(System.in);    
   } 

   public int getInput(){
       try {
           return input.nextInt();
       }
       catch (Exception e){
           System.out.println("Hanya Bisa Dimasukan Angka !!!");
           flush();
           return -100;
       }
        
   }
   
   public void flush(){
    input.nextLine();
   }
   
   public String getInputString() {
      return input.next(); // user enters an integer
   } 
} 