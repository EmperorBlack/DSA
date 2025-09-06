package google.minFlipToMakeGridPalliandrome;

public class MinFlipToMakeGridPalliandromeDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public int minFlips(int[][] grid) {

    int ans =0;
    int m = grid.length;
    int n = grid[0].length;

//    calculate quadratic space
    for (int i = 0; i < m/2 ; i++) {
      for (int j = 0; j < n/2; j++) {

        int cnt =0;

        cnt += grid[i][j];
        cnt += grid[i][n-j-1];
        cnt += grid[m-i-1][j];
        cnt += grid[m-i-1][n-j-1];

        ans += Math.min(cnt, 4-cnt);
      }
    }

    int diff = 0;
    int p0 =0;
    int p1 =0;

    if(m%2 == 1){
      for (int i = 0; i < n/2; i++) {

        if(grid[m/2][i] != grid[m/2][n-i-1]){
          diff++;
        }else{
          if(grid[m/2][i] == 0){
            p0++;
          }else{
            p1++;
          }
        }
      }
    }

    if(n%2 ==1 ){
      for (int i = 0; i < m/2; i++) {

        if(grid[i][n/2] != grid[m-1-i][n/2]){
          diff++;
        }else{
          if(grid[i][n/2]==0){
            p0++;
          }else{
            p1++;
          }
        }
      }
    }

    if(n%2 ==1 && m%2 ==1){
      if(grid[m/2][n/2] ==1){
        ans++;
      }
    }

//    int ans1 = 0;
//    if(diff ==0){
//      ans1 = 2;
//    }else{
//      ans1 = diff;
//    }
    int ans1 = Integer.MAX_VALUE;
    if(diff%2 == p1%2) {
      ans1 = diff;
    } else {
      if(diff%2==0) {
        if(diff==0) {
          ans1 = 2;
        } else {
          ans1 = diff;
        }
      } else {
        ans1 = diff;
      }
    }

    return ans+ans1;

  }
}
