package array.shipPackage;

import java.util.Arrays;

public class ShipPackageDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().shipWithinDays(new int[]{1,2,3,1,1},4));
  }
}


class Solution {
  public int shipWithinDays(int[] weights, int days) {

    return searchAnswer(getMaxElement(weights),getMaxWeightCanBe(weights),weights,days);

  }

  private int searchAnswer(int l, int r, int[] weights, int days){

    if(l>r){
      return l;
    }

    int mid = l+(r-l)/2;
    int getDay = countDays(weights,mid);
    if(getDay <= days){
      return searchAnswer(l,mid-1,weights,days);
    }else{
      return searchAnswer(mid+1,r,weights,days);
    }

  }

  private int countDays(int[] weights, int maxWeight){

    int tempWeight = 0;
    int count = 1;
    for (int i = 0; i < weights.length; i++) {

      if(tempWeight+weights[i] > maxWeight){
        count++;
        tempWeight = weights[i];
      }else{
        tempWeight = tempWeight+weights[i];
      }
    }
    return count;

  }

  private int getMaxWeightCanBe(int[] weights){
    return Arrays.stream(weights).sum();
  }
  private int getMaxElement(int[] weights){
    return Arrays.stream(weights).max().getAsInt();
  }
}