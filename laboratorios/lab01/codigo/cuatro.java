
public class cuatro
{
    public int triangle(int rows) {
  
    if(rows == 0)                        
         return 0;

         return rows + triangle(rows-1);

// siendo n, numero de filas T(n)= T(n-1) + c_2--> T(n) = c_2 n + c_1 (where c_1 is an arbitrary parameter)
//RSolve[T[n] == Subscript[c, 2] + T[-1 + n], {T[n]}, n]
}
}