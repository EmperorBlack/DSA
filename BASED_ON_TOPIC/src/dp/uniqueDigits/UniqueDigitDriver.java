package dp.uniqueDigits;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueDigitDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().countNumbersWithUniqueDigits(0));

  }
}


class Solution_3 {
  public int countNumbersWithUniqueDigits(int n) {

    if(n ==0){
      return 1;
    }

    if(n == 1){
      return 10;
    }

    int sum  = 9;
    int count =9;
    int num = n-1;

    while(num > 0){
      sum = count*sum;
      count--;
      num--;
    }

    return sum + countNumbersWithUniqueDigits(n-1);

  }
}


class Solution {
  public int countNumbersWithUniqueDigits(int n) {

    if(n ==0){
      return 1;
    }
    return countRecursive(n,new HashSet<>(),new StringBuilder(),Math.pow(10,n))  ;

  }

  private int countRecursive(int n, Set<Integer> set, StringBuilder current, double max){

    if(n == 0){
      return 0;
    }

    int count =0;
    for(int i = 0; i <= 9; i++){

      if (current.isEmpty() && i == 0) {
        count ++; // Count the number 0
        continue;
      }

      if(!set.contains(i)){
        current.append(i);
        if(Integer.parseInt(current.toString()) < max){
          set.add(i);
          count++;
          count+= countRecursive(n-1,set,current,max);
          set.remove(i);
        }
        current.deleteCharAt(current.length()-1);
      }



    }
    return count;

  }
}

class Solution_2 {
  public int countNumbersWithUniqueDigits(int n) {

    if(n ==0){
      return 1;
    }

    Map<String, Integer> map = new HashMap<>();

    return countRecursive(n,0,new StringBuilder(),Math.pow(10,n), map)  ;

  }

  private int countRecursive(int n, int visited, StringBuilder current, double max, Map<String,Integer> dp){

    if(n == 0){
      return 0;
    }

    int count =0;
    for(int i = 0; i <= 9; i++){

      if (current.isEmpty() && i == 0) {
        count ++; // Count the number 0
        continue;
      }

      if(dp.containsKey(n+visited+current.toString())){
        return dp.get(n+visited+current.toString());
      }


      if(((visited >> i) & 1) != 1){
        current.append(i);
        if(Integer.parseInt(current.toString()) < max){
          visited = visited | (1<<i);
          count++;
          count+= countRecursive(n-1,visited,current,max,dp);
          visited = visited ^ 1 << i ;
        }
        current.deleteCharAt(current.length()-1);
      }

    }
    dp.put(n+visited+current.toString(),count);
    return count;

  }
}

