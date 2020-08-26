public class Punto2_2 {

  public static boolean groupSum6(int start, int[] nums, int target) {
      if(target == 0 && start == nums.length) // c1 = 5 = T(0
        return true;
      else if (target !=0 && start == nums.length) // c1 = 5 = T(0)
        return false;
      else if(nums[start]==6)
          return groupSum6(start+1,nums,target-nums[start]);
          //C2 = 7
          /* T(n) = T(n-1) + C2
            T(n) = C2*n + C1 
          */  
      else
        return  groupSum6(start+1,nums,target-nums[start]) || groupSum6(start+1,nums,target); // c3 = C2
        // T(n) = T(n-1) + T(n-1) + C2
        // T(n) = C2(2^n-1) +C1*2^(n-1)
        // n es el numero de espacios restantes para terminar el arreglo
    }
    
  public static boolean groupSumClump(int start, int[] nums, int target) {
     if(target == 0 && start == nums.length ) //C0.1 = 4
          return true; //C1 = 6 = T(0)
      else if (target !=0 && start == nums.length) //C0.2 = 8 
           return false; // C2 = 10 + C0.2
      else if(start == nums.length-1) // C0.3 = 13
            return groupSumClump(start +1 ,nums, target-nums[start]) || groupSumClump(start +1 ,nums, target); 
            /* C3 = 14
               T(n) = T(n-1)+T(n-1) + C_4
              T(n)=C4(2^n-1) +C1*2^(n-1)
            */
      
       else if(nums[start] == nums[start+1]  && -start+nums.length-1 >= 1) //C0.4 = 23
            return groupSumClump( start+2, nums,  target-2*nums[start])||groupSumClump( start+2, nums,target); 
            /*4 = 31
              T(n) = T(n-2) + T(n-2) + C_3
              T(n)=2^(1/2)*(C2(-1)^(n)+ C1) - C3
            */ 
      else 
         return groupSumClump(start +1 ,nums, target-nums[start]) || groupSumClump(start +1 ,nums, target);
         /* 
         C5 = 39
        T(n) = T(n-1)+T(n-1) + C_5
        T(n)=C5(2^n-1) +C1*2^(n-1)
        */
    }
    
  public  static boolean groupSum5(int start, int[] nums, int target) {
     if(target == 0 && start >= nums.length) // C0.1 = 4
        return true; //C1 = 6
      else if (target !=0 && start >= nums.length) // C0.2 = 8
         return false;// C2 = 10
      else if(nums[start]%5==0  && -start+nums.length-1 >= 1 &&nums[start+1] ==1) // C0.3 = 8
            return groupSum5(start+2,nums,target-nums[start]);
            /* C3 = 13
              T(n) = T(n-2) + C_3
              T(n) = -(1/4)*C3*((-1)^(2n)-2n) + C2*(-1)^(n) +C1
            */
         else if(nums[start]%5==0 ) // C0.4 = 11
         return groupSum5(start+1,nums,target-nums[start]);
         /* C4 = 16
         T(n) = T(n-1) + C_4
         T(n) = C4*n + C1       
         */
          else
          return  groupSum5(start+1,nums,target-nums[start]) || groupSum5(start+1,nums,target);
          /* C5= 18
          T(n) = T(n-1) + T(n-1) + C_5 
          T(n)=C5(2^n-1) +C1*2^(n-1)
          */
      }
      public  static boolean groupNoAdj(int start, int[] nums, int target) {
        if(target == 0) // C0.1 = 2
        return true; //C1 = 4
        else if(target<0 ||( nums.length==start)) // C0.2 = 7
        return false; // C2 = 9 
        else if(nums.length -start > 1 ) // C0.3 = 11
       return  groupNoAdj(start + 2,nums, target-nums[start]) || groupNoAdj(start+1,nums, target);
       /* C3 = 18
          T(n) = T(n-2) + T(n-1) + C_3
          T(n) = -C3+ C1*F(n) + C2*L(n)
          with F(n) the nth fibonacci number and L(n) the nth lucas number

       */
        else
         return groupNoAdj(start+1,nums, target-nums[start]) || groupNoAdj(start+1,nums, target);
         /* C4 = 18
          T(n) = T(n-1) + T(n-1) + C4
          T(n)= C4(2^n-1) +C1*2^(n-1)
         */
      }
        public static boolean splitArray(int[] nums) {
           return splitArrayAux(0,nums,0,0);
          }
          
          private static boolean  splitArrayAux(int start,int[] nums,int targetA, int targetB) {
           if(start >= nums.length) // C0.1 = 5 
              return targetA == targetB; //C1 = 7
          else{
              int x = nums[start];
              return splitArrayAux(start+1 ,nums, targetA+ x, targetB) || splitArrayAux(start+1 ,nums, targetA,x+ targetB);
          /* C2 = 16
              T(n) = T(n-1)+T(n-1)+C_2
              T(n)= C2(2^n-1) +C1*2^(n-1)
          */
  
          }
         }
        }