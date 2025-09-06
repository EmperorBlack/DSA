package array.kokoEatingBanana;

public class KokoEatingBananaDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minEatingSpeed(new int[]{3,6,7,11},8));
  }
}


class Solution {
  public int minEatingSpeed(int[] piles, int h) {

    int max = findMax(piles);
    return minSpeedBS(piles,1,max,h);

  }

  private int minSpeedBS(int[] piles, int i, int j, int h){

    if(i > j){
      return i;
    }

    int mid = i + (j-i)/2;
    if(getHours(piles,mid) <= h ){
      return
      minSpeedBS(piles,i,mid-1,h);
    }else{
      return minSpeedBS(piles,mid+1,j,h);
    }


  }

  private long getHours(int[] piles, int speed){

    long hours = 0;
    for (int i = 0; i < piles.length; i++) {

      hours = hours+(piles[i]/speed);
      if(piles[i]%speed != 0){
        hours++;
      }

    }
    return hours;

  }

  private int findMax(int []nums){
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(max,nums[i]);
    }
    return max;
  }
}
