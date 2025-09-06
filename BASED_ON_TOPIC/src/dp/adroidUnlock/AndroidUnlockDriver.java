package dp.adroidUnlock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AndroidUnlockDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public int numberOfPatterns(int m, int n) {

    int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

    int[][] jump = new int[10][10];
    jump[1][9] = 5; jump[1][3] = 2; jump[1][7] = 4;
    jump[9][1] = 5; jump[9][3] = 6; jump[9][7] = 8;
    jump[3][1] = 2; jump[3][7] = 5; jump[3][9] = 6;
    jump[7][1] = 4; jump[7][3] = 5; jump[7][9] = 8;
    jump[2][8] = 5;jump[8][2] = 5;jump[4][6] = 5;jump[6][4] = 5;

    boolean[] visited = new boolean[10];
    int totalPattern =0;

    totalPattern += countPatternsFromNumber(1,1,m,n,jump,visited) * 4;
    totalPattern += countPatternsFromNumber(2,1,m,n,jump,visited) * 4;
    totalPattern += countPatternsFromNumber(5,1,m,n,jump,visited);
    return totalPattern;



  }

  private int countPatternsFromNumber(int currNum, int currLength, int minLength, int maxLength, int[][] jump, boolean[] visited){

    if(currLength > maxLength){
      return 0;
    }

    int validPattern = 0;
    if(currLength >= minLength){
      validPattern++;
    }

    visited[currNum] = true;
    for (int nextNum  = 1; nextNum  <= 9; nextNum ++) {
      int jumpOverNum = jump[currNum][nextNum];
      if(!visited[nextNum] && (jumpOverNum ==0 || visited[jumpOverNum])){
        validPattern += countPatternsFromNumber(nextNum, currLength+1,minLength, maxLength, jump,visited);
      }
    }
    visited[currNum] = false;
    return validPattern;


  }
}


class Solution_memo {
  public int numberOfPatterns(int m, int n) {
    int[][] jump = new int[10][10];
    jump[1][3] = jump[3][1] = 2;
    jump[1][7] = jump[7][1] = 4;
    jump[3][9] = jump[9][3] = 6;
    jump[7][9] = jump[9][7] = 8;
    jump[1][9] = jump[9][1] = 5;
    jump[2][8] = jump[8][2] = 5;
    jump[3][7] = jump[7][3] = 5;
    jump[4][6] = jump[6][4] = 5;

    // memo[currDigit][visitedMask][length]
    int[][][] memo = new int[10][1 << 10][10];
    for (int[][] grid : memo)
      for (int[] row : grid)
        Arrays.fill(row, -1);

    int total = 0;
    total += dfs(1, 1 << 1, 1, m, n, jump, memo) * 4;
    total += dfs(2, 1 << 2, 1, m, n, jump, memo) * 4;
    total += dfs(5, 1 << 5, 1, m, n, jump, memo);

    return total;
  }

  private int dfs(int curr, int mask, int len, int m, int n, int[][] jump, int[][][] memo) {
    if (len > n) return 0;
    if (memo[curr][mask][len] != -1) return memo[curr][mask][len];

    int count = (len >= m) ? 1 : 0;

    for (int next = 1; next <= 9; next++) {
      int bit = 1 << next;
      int j = jump[curr][next];
      if ((mask & bit) == 0 && (j == 0 || (mask & (1 << j)) != 0)) {
        count += dfs(next, mask | bit, len + 1, m, n, jump, memo);
      }
    }

    memo[curr][mask][len] = count;

    return count;

  }

//  [0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1]
}
