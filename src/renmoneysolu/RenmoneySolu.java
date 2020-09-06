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
   /*
    static int Afactor = 16807; static int Bfactor = 48271;
            
    static int divisor = 2147483647;        
   
   The generator variables have be declared in the IGeneratorUtility.java class as constant for proper memory optimization
   To speed up the Big O Notation.
   */
   
   static int comparisonCounter = 0;  //This is going to store the number of comparison count. basically the answer
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       
       
        try{
            //Reading values from the command line
            
            Scanner scanner = new Scanner(System.in);
            long A = scanner.nextLong();
            long B = scanner.nextLong();     //We store the values in a long to avoid a MemoryOutOfBound Exception
            
            Solveproblem problem = new Solveproblem( A, B, numberofIterations);
            
            comparisonCounter = problem.solve();            
            
                 
            System.out.println("Result of comparison "+ comparisonCounter);
        }
        catch(Exception e){
            System.err.println(e.getCause() + " "+e.getMessage());
        }
       
    }

       
 
}

