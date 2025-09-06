package array.repeateAndMissing;

import java.util.ArrayList;
import java.util.Arrays;

public class RepeateAndMissingDriver {

  public static void main(String[] args) {

    new Solution().findTwoElement(new int[]{4,3,6,2,1,1});
  }

}

class Solution {
  // Function to find two elements in array
  ArrayList<Integer> findTwoElement(int arr[]) {
    // code here
    double n = arr.length;
    double actualSum = (n*(n+1))/2;
    double arraySum = 0;
    double sqrArrSum = 0;
    for (int num : arr){
      arraySum += num;
      sqrArrSum += (num*num);
    }

    double sumDiff = actualSum - arraySum;
    double sqrActualSum = ((n*(n+1))*((2*n)+1))/6;
    double sqrSumDiff = sqrActualSum -sqrArrSum;

    double xPlusY = sqrSumDiff/sumDiff;
    double x = (xPlusY + sumDiff)/2;
    double y = xPlusY-x;

    System.out.println(x + "   " + y);

    ArrayList<Integer> list = new ArrayList<>();
    list.add(((int)y));
    list.add((int)x);
    return list;
  }
}
