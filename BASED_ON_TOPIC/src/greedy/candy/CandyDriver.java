package greedy.candy;

public class CandyDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().candy(new int[]{1,3,2,2,1}));
  }
}

class Solution {
  public int candy(int[] ratings) {


    int[] maxFromLeft = new int[ratings.length];
    int[] maxFromRight = new int[ratings.length];

    maxFromLeft[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if(ratings[i] > ratings[i-1]){
        maxFromLeft[i] = maxFromLeft[i-1]+1;
      }else{
        maxFromLeft[i] = 1;
      }
    }

    for (int i = ratings.length-2; i >= 0; i--) {
      if(ratings[i] > ratings[i+1]){
        maxFromRight[i] = maxFromRight[i+1]+1;
      }else{
        maxFromRight[i] = 1;
      }
    }

    int candy = 0;
    maxFromLeft[ratings.length-1] = 1;
    for (int i = 0; i < ratings.length; i++) {
      candy += Math.max(maxFromLeft[i],maxFromRight[i]);
    }
    return candy;
  }
}

//there is slope technique you can learn for better performance;