package recursion.palliandromePartition;

import java.util.ArrayList;
import java.util.List;

public class PalliandromePartitionDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().partition(""));
  }
}



class Solution {
  public List<List<String>> partition(String s) {

    List<List<String>> result = new ArrayList<>();
    partition(s,0,new ArrayList<>(),result);
    return result;

  }

  public void partition(String s,int start, List<String> temp, List<List<String>> result) {

    if(start == s.length()){
      result.add(new ArrayList<>(temp));
    }

    for (int i = start; i < s.length(); i++) {

      if(isPalliandrome(start,i,s)){
        temp.add(s.substring(start,i+1));
        partition(s,i+1,temp,result);
        temp.remove(temp.size()-1);
      }

    }


  }


  public boolean isPalliandrome(int i, int j, String s){

    while (i<=j){
      if(s.charAt(i) != s.charAt(j)){
        return false;
      }
      i++;
      j--;
    }
    return true;

  }


}
