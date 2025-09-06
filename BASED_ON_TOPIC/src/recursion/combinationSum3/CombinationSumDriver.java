package recursion.combinationSum3;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().combinationSum3(3,7));
  }
}


class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {

    List<List<Integer>> result = new ArrayList<>();
    combinationSum3(k,n,9,new ArrayList<>(),result);
    return result;
  }


  public void combinationSum3(int k, int n,int num, List<Integer> temp, List<List<Integer>> result) {


    if( k == 0 && n == 0){
      result.add(new ArrayList<>(temp));
      return;
    }

    if (n < 0 || num < 1 || k<=0){
      return;
    }

    if(n >= num){
      temp.add(num);
      combinationSum3(k-1,n-num,num-1,temp,result);
      temp.remove(temp.size()-1);
    }
    combinationSum3(k,n,num-1,temp,result);

  }
}