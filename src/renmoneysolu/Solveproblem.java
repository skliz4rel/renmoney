/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renmoneysolu;

/**
 *
 * @author user
 */
public class Solveproblem {
    
     int comparisonCounter = 0;  //This is going to store the number of comparison count. basically the answer
      
    //This variables below are needed for computation
    //int Afactor = 0, Bfactor = 0, divisor=0;          
   
   long A = 0, B=0;
   
   int numberofIterations = 0;
   
   //This class has the generator modules can be extended with more functionalities
   private IGeneratorUtility generatorObj =null;
   
    public Solveproblem(long A, long B,  int numberofIterations){
          
          this.A = A;
          this.B = B;
          
          this.numberofIterations =  numberofIterations;
          
          generatorObj = new GeneratorUtility();
      }
    
        
      public int solve(){
            
            for(int k=0; k< numberofIterations; k++){
                
                //This is the generator object used to generate values
               long[] values =  generatorObj.generate( A,  B);  //This method is going to perform the computation
               
               A = values[0]; B = values[1];
               
               
               //We would do the comparison below
              long reminderA = A;long reminderB = B;
              doComparison(reminderA, reminderB);
               
               //System.out.println("parENT " +A +"  "+B);
            }
            
            return comparisonCounter;
      }
      
    
       private void doComparison(long reminderA, long reminderB){
        
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
    private String[] returnFormatedStr(String binaryA, String binaryB){
        
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
    
    private String add0sbeforeNums(int diff, String number){
        
         String preceeding0s = "";
            
            while(diff >0){
                preceeding0s += "0";
                diff--;
            }
            
            number = preceeding0s+number;
            
            return number;
    }
    
    private String getlast8Digit(String value){
        return value.substring(value.length()-8, (value.length()));
    }
    
    
}
