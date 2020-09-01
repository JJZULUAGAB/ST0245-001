
public class array2_2
{
 
    public boolean has22(int[] nums) {
      for(int i = 0; i < nums.length - 1; i++) {
         if(nums[i] == 2 && nums[i + 1] == 2)
            return true;
 }
   return false;
}


public int centeredAverage(int[] nums) {
    int sum = 0;
    int min = nums[0];
    int max = nums[0];
         
    for(int i = 0; i < nums.length; i++) {
        sum += nums[i];
        min = Math.min(min, nums[i]);
        max = Math.max(max, nums[i]);
    }
                           
    return (sum - min - max) / (nums.length - 2);
}

    
public boolean haveThree(int[] nums) {
    int count = 0;
    
    if(nums.length >= 1 && nums[0] == 3)
        count++;
    for(int i = 1; i < nums.length; i++) {
        if(nums[i - 1] == 3 && nums[i] == 3)
            return false;
        if(nums[i] == 3)
            count++;
    }
    return count == 3;
}

public boolean isEverywhere(int[] nums, int val) {
    for(int i = 0; i < nums.length - 1; i++) {
        if(nums[i] != val && nums[i + 1] != val)
            return false;
    }
                
    return true;
}

public int matchUp(int[] nums1, int[] nums2) {
    int count = 0;
    
    for(int i = 0; i < nums1.length; i++) {
        if(Math.abs(nums1[i] - nums2[i]) <= 2 && nums1[i] != nums2[i])
            count++;
    }
                    
    return count;
}

}
