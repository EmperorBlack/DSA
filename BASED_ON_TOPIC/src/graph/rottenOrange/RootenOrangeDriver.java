package graph.rottenOrange;

import java.util.ArrayDeque;
import java.util.Queue;

public class RootenOrangeDriver {

  public static void main(String[] args) {

    int[][] input = {{2,1,1},{1,1,0},{0,1,1}};
    System.out.println(new Solution_dfs().orangesRotting(input));
  }
}

class Pair{
  int i;
  int j;

  public Pair(int i, int j) {
    this.i = i;
    this.j = j;
  }
}
class Solution {
  public int orangesRotting(int[][] grid) {

    Queue<Pair> queue = new ArrayDeque<>();
    int rotten = 0;
    int fresh = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {

        if(grid[i][j] == 2){
          queue.offer(new Pair(i,j));
          rotten++;
        } else if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }

    if(fresh == 0){
      return 0;
    }

    int count =0;
    int[] delRow  = {-1,0,1,0};
    int[] delCol = {0,1,0,-1};
    while (!queue.isEmpty() && fresh > 0 ){

      int size = queue.size();
      for (int i = 0; i < size; i++) {

        Pair curr = queue.poll();

        for (int j = 0; j < 4; j++) {

          int delI = curr.i+delRow[j];
          int delJ = curr.j+delCol[j];

          if(delI >=0 && delJ >=0 && delI < grid.length && delJ < grid[0].length && grid[delI][delJ] == 1   ){
            fresh--;
            grid[delI][delJ] = 2;
            queue.offer(new Pair(delI,delJ));
          }
        }


      }
      count++;
    }

    if(fresh > 0){
      return -1;
    }
    return count;
  }
}

class Solution_dfs {
  public int orangesRotting(int[][] grid) {

    for (int i = 0; i < grid.length; i++) {

      for (int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 2){
          dfs(grid,i,j,2);
        }
      }
    }

    int minute = 2;
    for (int i = 0; i < grid.length; i++) {

      for (int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 1){
         return -1;
        } else if (grid[i][j] > minute) {
          minute = grid[i][j];
        }
      }
    }
    return minute-2;
  }

  private void dfs(int[][] grid,int i, int j, int minute){

    if(i< 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < minute)){
      return;
    }

    grid[i][j] = minute;
    dfs(grid, i+1, j, minute+1);
    dfs(grid, i-1, j, minute+1);
    dfs(grid, i, j+1, minute+1);
    dfs(grid, i, j-1, minute+1);

  }
}
