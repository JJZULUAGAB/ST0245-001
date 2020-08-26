

public class cinco
{
   public int countHi(String str) {
       if(str.length() < 2)                          
        return 0; 
    else if(str.substring(0, 2).equals("hi"))               
        return 1 + countHi(str.substring(2));

            return countHi(str.substring(1)); 
    
//siendo n, tamaño del arreglo --> T(n)=c_3 +T(n-1)	-->T(n) = c_3 n + c_1 (where c_1 is an arbitrary parameter)
//RSolve[T[n] == Subscript[c, 3] + T[-1 + n], {T[n]}, n]
}
}