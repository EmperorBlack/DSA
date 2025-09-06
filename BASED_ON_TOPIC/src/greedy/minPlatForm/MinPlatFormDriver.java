package greedy.minPlatForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPlatFormDriver {

  public static void main(String[] args) {

    System.out.println(Solution.findPlatform(new int[]{2148,2334,338,25,2121,2353,1125,2358,1023}, new int[]{2238,2349,1518,939,2147,2355,2233,2359,2200}));
  }
}


class Solution {
  // Function to find the minimum number of platforms required at the
  // railway station such that no train waits.
  static int findPlatform(int arr[], int dep[]) {
    // add your code here

    int maxPlatForm =0;
    int i =0;
    int j =0;
    int count=0;

    Arrays.sort(arr);
    Arrays.sort(dep);

    while(i < arr.length && j < arr.length){
      if(arr[i] <= dep[j]){
        count++;
        i++;
      }else{
        count--;
        j++;
      }
      maxPlatForm = Math.max(maxPlatForm,count);

    }
    return maxPlatForm;

  }
}
