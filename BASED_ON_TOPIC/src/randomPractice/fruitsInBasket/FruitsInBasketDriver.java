package randomPractice.fruitsInBasket;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasketDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().totalFruit(new int[]{1,2,3,2,2}));
  }
}

class Solution {
  public int totalFruit(int[] fruits) {

    Map<Integer,Integer> map = new HashMap<>();
    int max =0;
    int l =0;
    for (int i = 0; i < fruits.length; i++) {

      map.put(fruits[i], map.getOrDefault(fruits[i],0)+1);

      if(map.size() > 2){
        map.put(fruits[l], map.get(fruits[l])-1);
        if(map.get(fruits[l]) == 0 ){
          map.remove(fruits[l]);
        }
        l++;
      }

//      if(map.size() <= 2){
        max = Math.max(max,i-l+1);
//      }

    }
    return max;
  }
}