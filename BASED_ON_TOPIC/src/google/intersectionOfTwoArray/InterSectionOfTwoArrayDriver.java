package google.intersectionOfTwoArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class InterSectionOfTwoArrayDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {

    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
    }

    for (int num : nums2){
      if(map.containsKey(num)){
        result.add(num);
        if(map.get(num) == 1){
          map.remove(num);
        }else {
          map.put(num,map.get(num)-1);
        }
      }
    }

    return result.stream().mapToInt(i->i).toArray();



  }
}