package google.shortestPathElimination;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathEliminationDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().shortestPath(new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}},1));
  }
}


class Info {
  int i, j, dist, obstacle;

  public Info(int i, int j, int dist, int obstacle) {
    this.i = i;
    this.j = j;
    this.dist = dist;
    this.obstacle = obstacle;
  }
}

class Solution {
  public int shortestPath(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;

    Queue<Info> queue = new ArrayDeque<>();
    queue.offer(new Info(0, 0, 0, 0));

    boolean[][][] visited = new boolean[m][n][k + 1];
    visited[0][0][0] = true;

    int[] delI = {1, 0, -1, 0};
    int[] delJ = {0, 1, 0, -1};

    while (!queue.isEmpty()) {
      Info info = queue.poll();

      if (info.i == m - 1 && info.j == n - 1) {
        return info.dist;
      }

      for (int d = 0; d < 4; d++) {
        int nextI = info.i + delI[d];
        int nextJ = info.j + delJ[d];

        if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n) {
          int nextObstacle = info.obstacle + grid[nextI][nextJ];
          if (nextObstacle <= k && !visited[nextI][nextJ][nextObstacle]) {
            visited[nextI][nextJ][nextObstacle] = true;
            queue.offer(new Info(nextI, nextJ, info.dist + 1, nextObstacle));
          }
        }
      }
    }

    return -1;
  }
}
