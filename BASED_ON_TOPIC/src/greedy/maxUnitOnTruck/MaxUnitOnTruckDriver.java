package greedy.maxUnitOnTruck;

import java.util.Arrays;

public class MaxUnitOnTruckDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().maximumUnits(new int[][]{{1,3},{2,2},{3,1}},4));
  }
}


class Solution {
  public int maximumUnits(int[][] boxTypes, int truckSize) {

    Arrays.sort(boxTypes,( int[] a, int[] b)-> Integer.compare(b[1],a[1]));

    int totalUnit =0;
    int i =0;
    while (truckSize > 0 && i < boxTypes.length){

      int[] currBoxType = boxTypes[i];
      int noOfBoxInCurrBoxType = currBoxType[0];
      int numOfBox = Math.min(truckSize, noOfBoxInCurrBoxType);
      totalUnit = totalUnit + (numOfBox*currBoxType[1]);
      truckSize = truckSize-numOfBox;
      i++;
    }

    return totalUnit;
  }
}
