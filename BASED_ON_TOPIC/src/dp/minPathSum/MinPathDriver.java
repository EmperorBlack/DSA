package dp.minPathSum;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinPathDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().minPathSum(new int[][]{
        {1,2,3},
        {4,5,6}
    }));
  }
}

class Pair {

  int x;
  int y;
  int dist;

  public Pair(int x, int y,int dist) {
    this.x = x;
    this.y = y;
    this.dist = dist;
  }
}


class Solution_graph {
  public int minPathSum(int[][] grid) {

    int[][] dp = new int[grid.length][grid[0].length];
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    Queue<Pair> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);

    q.offer(new Pair(0, 0, grid[0][0]));
    dp[0][0] = grid[0][0];

    while (!q.isEmpty()){

      Pair p = q.poll();
      if(p.x == m-1 && p.y == n-1){
        return p.dist;
      }

      if(p.x+1 < m  && dp[p.x+1][p.y] > p.dist + grid[p.x+1][p.y]){
        q.offer(new Pair(p.x+1, p.y, p.dist + grid[p.x+1][p.y]));
      }
      if(p.y+1 < n && dp[p.x][p.y+1] > p.dist + grid[p.x][p.y+1]){
        q.offer(new Pair(p.x, p.y+1, p.dist + grid[p.x][p.y+1]));
      }
    }

    return -1;


  }
}

class Solution {
  public int minPathSum(int[][] grid) {


    int m = grid.length;
    int n = grid[0].length;

    for (int i = 1; i < m; i++) {
      grid[i][0] += grid[i-1][0];
    }

    for (int i = 1; i < n; i++) {
      grid[0][i] = grid[0][i] + grid[0][i-1];
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        grid[i][j] = Math.min(grid[i][j-1],grid[i-1][j])+grid[i][j];
      }
    }


    return grid[m-1][n-1];


  }
}
