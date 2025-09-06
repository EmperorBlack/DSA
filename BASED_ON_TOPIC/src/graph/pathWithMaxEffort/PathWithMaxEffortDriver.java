package graph.pathWithMaxEffort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaxEffortDriver {

  public static void main(String[] args) {

  }
}

class Pair {
  int i;
  int j;
  int maxEffort;

  public Pair(int i, int j, int maxEffort) {
    this.i = i;
    this.j = j;
    this.maxEffort = maxEffort;
  }
}

class Solution {
  public int minimumEffortPath(int[][] heights) {

    Queue<Pair> queue = new PriorityQueue<>((p1,p2)-> Integer.compare(p1.maxEffort,p2.maxEffort));
    queue.offer(new Pair(0,0,0));

    int[][] efforts = new int[heights.length][heights[0].length];
    for (int[] effort : efforts){
      Arrays.fill(effort,Integer.MAX_VALUE);
    }

    efforts[0][0] = 0;

    int[] deltaRow = {0,1,0,-1};
    int[] deltaCol = {-1,0,1,0};

    while (!queue.isEmpty()){

      Pair curr = queue.poll();

      if(curr.i == heights.length-1 && curr.j == heights[0].length-1){
        return curr.maxEffort;
      }

      for (int i = 0; i < 4; i++) {

        int deltaI = curr.i+deltaRow[i];
        int deltaJ = curr.j+deltaCol[i];


        if(deltaI >=0 && deltaI < heights.length && deltaJ >=0 && deltaJ < heights[0].length){
          int diff = Math.abs(heights[curr.i][curr.j] - heights[deltaI][deltaJ]);
          int maxPathEfforts = Math.max(diff, curr.maxEffort);

          if(maxPathEfforts < efforts[deltaI][deltaJ]){
            efforts[deltaI][deltaJ] = maxPathEfforts;
            queue.offer(new Pair(deltaI,deltaJ,maxPathEfforts));
          }

        }

      }



    }

return -1;

  }
}