package slidingWindowAndTwoPointer.defuseBumb;

import java.util.Arrays;

public class DefuseBombDriver {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().decrypt(new int[]{2,4,9,3},-2)));
  }
}

class Solution {
  public int[] decrypt(int[] code, int k) {

    if(k==0){
      return new int[code.length];
    }


    int ck = code.length * 2;
    int[] result = new int[code.length];

    if(k < 0){
      k = -k;
      int sum =0;
      int last =0;
      for(int i =0;i<ck;i++){
        int di = i%code.length;
        result[di] = sum;
        sum = sum + code[di];
        if(i >= k){
          sum = sum-code[last%code.length];
          last++;
        }
      }
    }else{

      int sum =0;
      int last = ck-1;
      for(int i =ck-1;i>=0;i--){
        int di = i%code.length;
        result[di] = sum;
        sum = sum+code[di];
        if(ck-i > k ){
          sum = sum-code[last%code.length];
          last--;
        }
      }
    }
    return result;


  }
}