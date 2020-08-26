
public class ffs
{
   
    public int factorial (int n) {
   if (n == 1) return 1;
    
   return n * factorial  (n-1);  

   // Cuando n= factorial... T(n)= c_2 + T(n-1) --> 
   //T(n) = c_2 n + c_1 (where c_1 is an arbitrary parameter) RSolve[T[n] == Subscript[c, 2] + T[-1 + n], {T[n]}, n]
} 

}
