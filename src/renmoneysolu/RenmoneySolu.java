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
        
        IGeneratorUtility generatorObj = new GeneratorUtility();
        
        try{
            //Reading values from the command line
            
            Scanner scanner = new Scanner(System.in);
            long A = scanner.nextLong();
            long B = scanner.nextLong();     //We store the values in a long to avoid a MemoryOutOfBound Exception
            
            for(int k=0; k< numberofIterations; k++){
                
                //This is the generator object used to generate values
               long[] values =  generatorObj.generator( A,  B, Afactor, Bfactor, divisor);  //This method is going to perform the computation
               
               A = values[0]; B = values[1];
               
               
               //We would do the comparison below
              long reminderA = A;long reminderB = B;
              doComparison(reminderA, reminderB);
               
               //System.out.println("parENT " +A +"  "+B);
            }
        }
        catch(Exception e){
            System.err.println(e.getCause() + " "+e.getMessage());
        }
             
        System.out.println("Result of comparison "+ comparisonCounter);
    }

    
    
      private static void doComparison(long reminderA, long reminderB){
        
        //System.out.println(reminderA + "  "+reminderB);
        
        String binaryA = Long.toBinaryString(reminderA); String binaryB =  Long.toBinaryString(reminderB);
        
        //System.out.println(binaryA + "  "+binaryB);
        
        //We are adding preceeding 00s so that both binary digits are equal in length. This would prevent any index out of bound exceptions
        String formated[] = returnFormatedStr( binaryA, binaryB);
        binaryA = formated[0];  binaryB = formated[1];
        
        //System.out.println("**  "+binaryA + "  "+binaryB);
        
        String last8digitinbinaryA = getlast8Digit(binaryA);
        String last8digitinbinaryB = getlast8Digit(binaryB);
        
        
        //System.out.println( last4digitinbinaryA+"\n"+last4digitinbinaryB+"\n");
        
        if(last8digitinbinaryA.equals(last8digitinbinaryB)){
            
           // System.out.println("  "  +true );
            comparisonCounter++;
        }
    }
    
    //This method is going to help add preceeding digits
    private static String[] returnFormatedStr(String binaryA, String binaryB){
        
        int lengthA = binaryA.length();  int lengthB = binaryB.length();
        
        try{
        
        if(lengthA < 8){
            int diff = 8 - lengthA;
            
            binaryA = add0sbeforeNums( diff, binaryA);            
        }
        
        if(lengthB < 8){
            int diff = 8-lengthB;
            
            binaryB = add0sbeforeNums(diff, binaryB);            
        }
        
        if(lengthA > lengthB){
            int diff = lengthA - lengthB;
            
            binaryB = add0sbeforeNums(diff, binaryB);
        }
        else{
            int diff = lengthB - lengthA;
            
            binaryA = add0sbeforeNums( diff, binaryA); 
          }
        }
        catch(Exception e){
            System.err.println(e.getCause()+" "+e.getMessage());
        }
        
        return new String[] { binaryA, binaryB };
    }
    
    private static String add0sbeforeNums(int diff, String number){
        
         String preceeding0s = "";
            
            while(diff >0){
                preceeding0s += "0";
                diff--;
            }
            
            number = preceeding0s+number;
            
            return number;
    }
    
    private static String getlast8Digit(String value){
        return value.substring(value.length()-8, (value.length()));
    }
    
 
}

