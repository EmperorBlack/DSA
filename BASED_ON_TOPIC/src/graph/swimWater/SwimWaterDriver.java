package graph.swimWater;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimWaterDriver {

  public static void main(String[] args) {

  }
}

class Pair{
  int i;
  int j;
  int time;

  public Pair(int i, int j, int time) {
    this.i = i;
    this.j = j;
    this.time = time;
  }
}

class Solution {
  public int swimInWater(int[][] grid) {

    Queue<Pair> queue = new PriorityQueue<>((a,b) -> a.time - b.time);
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];

    int[] delRow = {0,1,0,-1};
    int[] delCol = {-1,0,1,0};

    queue.add(new Pair(0,0,grid[0][0]));
    visited[0][0] = true;
    while(!queue.isEmpty()){
      Pair curr = queue.poll();
      if(curr.i == rows-1 && curr.j == cols-1){
        return curr.time;
      }
      for (int i = 0; i < 4; i++) {
        int delI = curr.i + delRow[i];
        int delJ = curr.j + delCol[i];

        if(delI >=0 && delJ >=0 && delI < rows && delJ < cols && !visited[delI][delJ]){
          visited[delI][delJ] = true;
          queue.add(new Pair(delI,delJ,Math.max(curr.time,grid[delI][delJ])));
        }
      }
    }
    return -1;


  }
}
