
public class tres
{
   public int bunnyEars2(int bunnies) {
        if(bunnies == 0)
                return 0;
 
       if(bunnies % 2 == 1)
                return 2 + bunnyEars2(bunnies-1);
  
                return 3 + bunnyEars2(bunnies-1);

    //siedno n, bunnies -->     T(n) = -c_2 + c_1 F_n + c_2 L_n (where c_1 and c_2 are arbitrary parameters)
    // RSolve[T[n] == Subscript[c, 2] + T[-2 + n] + T[-1 + n], {T[n]}, n]
}
}