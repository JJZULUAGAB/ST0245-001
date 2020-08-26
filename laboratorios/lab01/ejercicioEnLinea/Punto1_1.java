
public class Punto1_1
{
    

        public int factorial (int n) {
        if (n == 1) return 1;
    
        return n * factorial  (n-1);  
    
    }

    
    
       
        public int bunnyEars(int bunnies) {
            if (bunnies == 0) return 0;
   
            return 2 + bunnyEars (bunnies-1);

       }
        
       
       public int bunnyEars2(int bunnies) {
        if(bunnies == 0)
                return 0;
 
       if(bunnies % 2 == 1)
                return 2 + bunnyEars2(bunnies-1);
  
                return 3 + bunnyEars2(bunnies-1);
        
        
    } 
    
    
     public int triangle(int rows) {
  
         if(rows == 0)                        
            return 0;
            
                return rows + triangle(rows-1);
    }

     public int countHi(String str) {
         if(str.length() < 2)                          
         return 0; 
        else if(str.substring(0, 2).equals("hi"))               
            return 1 + countHi(str.substring(2));

            return countHi(str.substring(1));
    

   } 
}
        
    