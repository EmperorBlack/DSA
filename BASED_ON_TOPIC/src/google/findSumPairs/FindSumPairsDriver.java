package google.findSumPairs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindSumPairsDriver {

  public static void main(String[] args) {

  }
}

class FindSumPairs {
  Map<Integer,Integer> map1 = new HashMap<>();
  Map<Integer,Integer> map2 = new HashMap<>();
  int[] nums2 = null;

  public FindSumPairs(int[] nums1, int[] nums2) {

    for (int num : nums1) {
      map1.put(num, map1.getOrDefault(num, 0) + 1);
    }
    for (int num : nums2){
      map2.put(num, map2.getOrDefault(num, 0) + 1);
    }
    this.nums2 = nums2;
  }

  public void add(int index, int val) {

    int oldValue = nums2[index];
    nums2[index] += val;
    int newValue = nums2[index];

    if(map2.containsKey(oldValue)){
      map2.put(oldValue, map2.get(oldValue)-1);
      if(map2.get(oldValue) == 0){
        map2.remove(oldValue);
      }
    }

    map2.put(newValue, map2.getOrDefault(newValue, 0) + 1);

  }

  public int count(int tot) {

    int count =0;
    for(Entry<Integer,Integer> entry : map1.entrySet()){
      int key = entry.getKey();
      if(map2.containsKey(tot -key)){
        count += entry.getValue() * map2.get(tot - key);
      }
    }
    return count;
  }

}
