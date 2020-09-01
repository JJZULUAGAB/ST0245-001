
public class array3_3
{
    
    public int[] seriesUp(int n) {
    int[] arr = new int[n*(n+1)/2];
    int index = 0;
    for(int i = 1; i <= n; i++) {
        for(int j = 0; j < i; j++) {
            arr[index + j] = j + 1;
        }
        index += i;
    }
    return arr;
   }
    
    public boolean canBalance(int[] nums) {
    int first = 0;
    int second = 0;
    for(int i = 0; i < nums.length; i++)
        second += nums[i];
    for(int i = 0; i <= nums.length - 2; i++) {
        first += nums[i];
        second -= nums[i];
        if(first == second)
            return true;
    }
    return false;
   }

    public int countClumps(int[] nums) {
    int count = 0;
    int i = 0;
    while(i < nums.length) {
        int val = nums[i];
        i++;
        int length = 1;
        while(i < nums.length && nums[i] == val) {
            i++;
            length++;
        }
        if(length > 1)
            count++;
    }
    return count;
   }

    public int maxMirror(int[] nums) {
    int max = 0;
    for(int i = 0; i < nums.length; i++) {
        int count = 0;
        for(int j = nums.length - 1; j >= 0 && i + count < nums.length; j--) {
            if(nums[i + count] == nums[j]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
    }
    return max;
   }

     public int[] squareUp(int n) {
     int[] arr = new int[n*n];
      if(n == 0)
            return arr;
        for(int i = n - 1; i < arr.length; i += n) {
            for(int j = i; j >= i - i / n; j--)
                arr[j] = i - j + 1;
                }
    return arr;
   }   

}
