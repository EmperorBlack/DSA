package google.minSwapDigit;

import java.util.Arrays;
import java.util.Comparator;

public class MinSwapDigitDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minSwaps(new int[]{346675656,436516098,372126778,781771807}));

  }
}
class Pair{
  int num;
  int digitSum;
  int index;
  Pair(int num,int sum, int index){
    this.num = num;
    this.digitSum = sum;
    this.index = index;
  }

}

class Solution {
  public int minSwaps(int[] nums) {


    Pair[] digitSum = new Pair[nums.length];

    for(int i =0;i< nums.length;i++){
      int num = nums[i];
      int sum =0;
      while(num>0){

        sum = sum + num%10;
        num = num/10;
      }
      digitSum[i] = new Pair(nums[i],sum,i);
    }

    Arrays.sort(digitSum, new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        if(o1.digitSum != o2.digitSum){
          return Integer.compare(o1.digitSum,o2.digitSum);
        }
        return Integer.compare(o1.num,o2.num);
      }
    });

    int count =0;
    for(int i=0;i< nums.length;i++){
      Pair p = digitSum[i];
      while(p.index != i){

        int index = p.index;
        digitSum[i] = digitSum[index];
        digitSum[index] = p;
        p= digitSum[i];
        count++;
      }

    }
    return count;




  }
}