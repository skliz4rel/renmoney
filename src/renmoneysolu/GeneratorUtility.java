/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renmoneysolu;

import static renmoneysolu.RenmoneySolu.Afactor;

/**
 *
 * @author user
 */
public class GeneratorUtility implements IGeneratorUtility {
    
     
       public long[] generator(long A, long B, int Afactor, int Bfactor, int divisor ){
               
            //Do reminder calculation for A
            
            long multofA = (A * Afactor);
            
            long reminderA = multofA % divisor;
            
            //Do reminder calculation for B.
            
            long multofB = (B * Bfactor);
            
            long reminderB = multofB % divisor;
            
            
            return new long[] { reminderA, reminderB };  // We return the reminder so we can continue the loop with the next reminder in the iteration.
    }
    
  
    
    
}
