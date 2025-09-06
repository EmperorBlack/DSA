package slidingWindowAndTwoPointer.fruitIntoBasket;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasketDriver {

  public static void main(String[] args) {

    System.out.println(Solution.totalFruits(new Integer[]{3,1, 2, 2, 2, 2}));
  }
}


class Solution {
  public static int totalFruits(Integer[] arr) {
    // code here

    Map<Integer,Integer> map = new HashMap();
    int maxFruit = 0;
    int start = 0;
    for (int i = 0; i < arr.length; i++) {

      if(map.containsKey(arr[i])){
        map.put(arr[i],map.get(arr[i])+1);
      }else{
        map.put(arr[i],1);
      }

      if(map.size() > 2){
        map.put(arr[start],map.get(arr[start])-1);
        if(map.get(arr[start]) ==0){
          map.remove(arr[start]);
        }
        start++;
      }

      if(map.size() <= 2){
        maxFruit = Math.max(maxFruit,i-start+1);
      }


    }
    return maxFruit;
  }
}