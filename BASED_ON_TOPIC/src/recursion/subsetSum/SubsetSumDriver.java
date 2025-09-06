package recursion.subsetSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public ArrayList<Integer> subsetSums(int[] arr) {
    // code here

    ArrayList<Integer> result = new ArrayList<>();
    subsetSums(arr, arr.length-1,0,result);
    return result;




  }

  public void subsetSums(int[] arr, int index,int sum , List<Integer> result){


    if(index < 0){
      result.add( sum);
      return;
    }

    subsetSums(arr,index-1,sum+arr[index],result);
    subsetSums(arr,index-1,sum,result);

  }



}
