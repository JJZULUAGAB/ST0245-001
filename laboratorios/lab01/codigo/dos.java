
public class dos
{
   public int bunnyEars(int bunnies) {
   if (bunnies == 0) return 0;
   
   return 2 + bunnyEars (bunnies-1);

   //siendo n= numero de filas -->T(n)= c1 + T(n-1)-->RSolve[T[n] == c1 + T[-1 + n], {T[n]}, n], 
   //T(n) = c1 n + c_1 (where c_1 is an arbitrary parameter)
}

    
}
