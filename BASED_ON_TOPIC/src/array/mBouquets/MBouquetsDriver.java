package array.mBouquets;

public class MBouquetsDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minDays(new int[]{1,10,3,10,2},3,1));
  }
}

class Solution {
  public int minDays(int[] bloomDay, int m, int k) {

    if(bloomDay.length < (long)m*k){
      return -1;
    }
    int j = findMax(bloomDay);
    return findMinDayBS(bloomDay,1,j,m,k);
  }

  private int findMinDayBS(int[] bloomDay,int i, int j, int m, int k){

    if(i > j){
      return i;
    }
    int mid = i + (j-i)/2;

    if(findBouquetsCount(bloomDay,mid,k) >= m){
      return findMinDayBS(bloomDay,i,mid-1,m,k);
    }else{
      return findMinDayBS(bloomDay,mid+1,j,m,k);
    }

  }

  private int findBouquetsCount(int[] bloomDay, int days, int adjFlwrNeeds){

    int bouquetsCount = 0;
    int tempBouquets = 0;
    for (int i = 0; i < bloomDay.length; i++) {

      if(bloomDay[i] <= days){
        tempBouquets++;
      }else{
        tempBouquets = 0;
      }

      if(tempBouquets!= 0 && tempBouquets % adjFlwrNeeds == 0){
        bouquetsCount++;
      }

    }
    return bouquetsCount;

  }

  private int findMax(int []nums){
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(max,nums[i]);
    }
    return max;
  }
}
