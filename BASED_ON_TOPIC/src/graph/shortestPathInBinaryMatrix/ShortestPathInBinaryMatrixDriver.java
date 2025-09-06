package graph.shortestPathInBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathInBinaryMatrixDriver {

  public static void main(String[] args) {

    int[][] matrix = {
        {0, 0, 0},
        {1, 1, 0},
        {1, 1, 0}
    };
    System.out.println(new Solution().shortestPathBinaryMatrix(matrix));
  }
}

class Pair{
  int i;
  int j;
  int dist;
  public Pair(int i, int j, int dist) {
    this.i = i;
    this.j = j;
    this.dist = dist;
  }
}

class Solution {
  public int shortestPathBinaryMatrix(int[][] grid) {

    if(grid[0][0] == 1){
      return -1;
    }

    Queue<Pair> queue = new ArrayDeque<>();

    queue.offer(new Pair(0,0,1));

    int[][] dist = new int[grid.length][grid[0].length];
    for (int[] d : dist){
      Arrays.fill(d, Integer.MAX_VALUE);
    }

    dist[0][0] = 1;

    while (!queue.isEmpty()){
      Pair curr = queue.poll();
      if(curr.i == grid.length-1 && curr.j == grid[0].length-1){
        return curr.dist;
      }

      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1 ; j++) {

          int deltaI = curr.i + i;
          int deltaJ = curr.j+ j;

          if((deltaI != curr.i || deltaJ != curr.j) &&  deltaI >=0 && deltaI < grid.length && deltaJ >= 0 && deltaJ < grid[0].length && grid[deltaI][deltaJ] ==0
           && dist[deltaI][deltaJ] > curr.dist + 1){
            dist[deltaI][deltaJ] = curr.dist + 1;
            queue.offer(new Pair(deltaI, deltaJ, curr.dist + 1));
          }
        }
      }
    }
    return -1;
  }
}

class Solution_2 {
  public int shortestPathBinaryMatrix(int[][] grid) {
    if(grid[0][0] == 1){
      return -1;
    }

    Queue<Pair> queue = new ArrayDeque<>();

    queue.offer(new Pair(0,0,1));


    while (!queue.isEmpty()){
      Pair curr = queue.poll();
      if(curr.i == grid.length-1 && curr.j == grid[0].length-1){
        return curr.dist;
      }

      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1 ; j++) {

          int deltaI = curr.i + i;
          int deltaJ = curr.j+ j;

          if((deltaI != curr.i || deltaJ != curr.j) &&  deltaI >=0 && deltaI < grid.length && deltaJ >= 0 && deltaJ < grid[0].length && grid[deltaI][deltaJ] != 1){
            grid[deltaI][deltaJ] = 1;
            queue.offer(new Pair(deltaI, deltaJ, curr.dist + 1));
          }
        }
      }
    }
    return -1;
  }
}

