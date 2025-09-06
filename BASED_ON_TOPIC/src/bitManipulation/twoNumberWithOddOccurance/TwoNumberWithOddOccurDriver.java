package bitManipulation.twoNumberWithOddOccurance;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberWithOddOccurDriver {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(new Solution().twoOddNum(
        new int[]{34, 52, 45, 15, 23, 23, 22, 22, 34, 52, 15, 9, 34, 23, 22, 43, 9, 23, 23, 23, 23,
            45, 9, 34, 22, 22, 22, 52, 34, 23, 34, 43, 23, 23, 34, 22, 22, 9, 52, 43, 27, 34
        }, 42)));
  }
}

class Solution
{
  public int[] twoOddNum(int Arr[], int N)
  {
    // code here
    Integer[] res = new Integer[2];

    Map<Integer,Integer> map = new HashMap<>();
    for(int n : Arr){
      map.put(n,map.getOrDefault(n,0)+1);
    }
    int i =0;
    for (Map.Entry<Integer,Integer> kv : map.entrySet() ){
      if(kv.getValue() % 2 == 1){
        res[i++] = kv.getKey();
      }
    }
    Arrays.sort(res, Collections.reverseOrder());
    return Arrays.stream(res).mapToInt(a->a).toArray();
  }
}

class Solution_1
{
  public int[] twoOddNum(int Arr[], int N)
  {

    long xorOfElement = 0;

    for (int i = 0; i < N; i++) {
      xorOfElement ^= Arr[i];
    }

    long elementWithRightMostBitSetOfXorOfElement = (xorOfElement & (xorOfElement-1))^xorOfElement;

    long bucket1 =0;
    long bucket2 = 0;
    for(int a : Arr){
      if((a & elementWithRightMostBitSetOfXorOfElement) != 0){
        bucket1 ^= a;
      }else{
        bucket2 ^= a;
      }
    }

    return new int[]{(int)(Math.max(bucket1, bucket2)), (int)(Math.min(bucket1, bucket2)) };
  }
}

// as two distinct number there will be minmum of one bit difference
//we can get any set bit and will check with every number.
//easiest way is get right most set bit.
// to get right most set bit, first we will set the bit to 0 by doing num & num-1
//now do a xor with result of & operation so that with will cancel all will give us only right most set bit.


