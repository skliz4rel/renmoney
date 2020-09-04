/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renmoneysolu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class RenmoneySolu {

    /**
     * @param args the command line arguments
     */
    
   static int numberofIterations = 1000000;
    
     //This variables below are needed for computation
    static int Afactor = 16807; static int Bfactor = 48271;
            
    static int divisor = 2147483647;
            
   
   static int comparisonCounter = 0;  //This is going to store the number of comparison count. basically the answer
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            //Reading values from the command line
            
            Scanner scanner = new Scanner(System.in);
            long A = scanner.nextLong();
            long B = scanner.nextLong();     //We store the values in a long to avoid a MemoryOutOfBound Exception
            
            for(int k=0; k< numberofIterations; k++){
               long[] values =  computation( A,  B);  //This method is going to perform the computation
               
               A = values[0]; B = values[1];
            }
        }
        catch(Exception e){
            System.err.println(e.getCause() + " "+e.getMessage());
        }
             
        System.out.println("Result of comparison "+ comparisonCounter);
    }

    public static long[] computation(long A, long B){
               
            //Do reminder calculation for A
            
            long multofA = (A * Afactor);
            
            long reminderA = multofA % divisor;
            
            //Do reminder calculation for B.
            
            long multofB = (B * Bfactor);
            
            long reminderB = multofB % divisor;
            
            
            doComparison(reminderA, reminderB);
            
            return new long[] { reminderA, reminderB };  // We return the reminder so we can continue the loop with the next reminder in the iteration.
    }
    
    private static void doComparison(long reminderA, long reminderB){
        
        //System.out.println(reminderA + "  "+reminderB);
        
        String binaryA = Long.toBinaryString(reminderA); String binaryB =  Long.toBinaryString(reminderB);
        
        String last4digitinbinaryA = getlast4Digit(binaryA);
        String last4digitinbinaryB = getlast4Digit(binaryB);
        
        //We are adding preceeding 00s so that both binary digits are equal in length. This would prevent any index out of bound exceptions
        String formated[] = returnFormatedStr( last4digitinbinaryA, last4digitinbinaryB);
        last4digitinbinaryA = formated[0];  last4digitinbinaryB = formated[1];
        
        
        //System.out.println( last4digitinbinaryA+"\n"+last4digitinbinaryB+"\n");
        
        if(last4digitinbinaryA.equals(last4digitinbinaryB)){
            
           // System.out.println("  "  +true );
            comparisonCounter++;
        }
    }
    
    //This method is going to help add preceeding digits
    private static String[] returnFormatedStr(String last4digitinbinaryA, String last4digitinbinaryB){
        
        int lengthA = last4digitinbinaryA.length();  int lengthB = last4digitinbinaryB.length();
        if(lengthA > lengthB){
            int diff = lengthA - lengthB;
            
            String preceeding0s = "";
            
            while(diff >0){
                preceeding0s += "0";
            }
            
            last4digitinbinaryB = preceeding0s + last4digitinbinaryB;
        }
        else{
            int diff = lengthB - lengthA;
            
            String preceeding0s = "";
            
            while(diff >0){
                preceeding0s += "0";
            }
            
            last4digitinbinaryA = preceeding0s + last4digitinbinaryA;
        }
        
        return new String[] { last4digitinbinaryA, last4digitinbinaryB };
    }
    
    private static String getlast4Digit(String value){
        return value.substring(value.length()-8, (value.length()));
    }
}

