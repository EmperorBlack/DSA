package google.candieTwo;

import java.util.Arrays;

public class CandieTwoDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().distributeCandies(3,3));
  }
}

class Solution {
  public long distributeCandies(int n, int limit) {

    long[][] dp = new long[n+1][4];
    for(int i =0;i< dp.length;i++){
      Arrays.fill(dp[i],-1);
    }

    return distribute(n, 3, limit,dp);

  }

  private long distribute(int n, int children, int limit, long[][] dp){

    if(children ==0){
      if( n==0){
        return 1;
      }else{
        return 0;
      }
    }

    if(dp[n][children] != -1){
      return dp[n][children];
    }

    int count = 0;
    for(int i =0; i<= limit && i<=n ;i++){
      count += (int) distribute(n-i,children-1,limit,dp);
    }
    return dp[n][children] = count;

  }
}


class Solution_2 {
  public long distributeCandies(int n, int limit) {

    int start = Math.max(0,n - (2* limit));
    long ways =0;

    for(int i =start;i<=Math.min(n,limit);i++){ // child 1


      int newN = n - i; // child 2 and 3
      int child2Min = Math.max(0,newN-limit);
      int child2Max = Math.min(newN,limit);
      ways+= child2Max-child2Min+1;

    }


return ways;
  }
}
