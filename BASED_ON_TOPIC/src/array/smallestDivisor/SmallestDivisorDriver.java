package array.smallestDivisor;

public class SmallestDivisorDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().smallestDivisor(new int[]{1,2,5,9},6));
  }
}

class Solution {
  public int smallestDivisor(int[] nums, int threshold) {

    return smallestDivisorBS(nums,1,findMax(nums),threshold);

  }

  private int smallestDivisorBS(int nums[], int i, int j, int threshold){
    if(i > j){
      return i;
    }

    int mid = i + (j-i)/2;
    if(findThreshold(nums, mid) > threshold){
      return smallestDivisorBS(nums,mid+1,j,threshold);
    }else{
      return smallestDivisorBS(nums,i,mid-1,threshold);
    }
  }

  private int findThreshold(int nums[], int divisor){

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {


        sum = sum + nums[i]/divisor;
        if(nums[i] % divisor != 0){
          sum++;
        }

    }
    return sum;
  }

  private int findMax(int []nums){
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(max,nums[i]);
    }
    return max;
  }
}
