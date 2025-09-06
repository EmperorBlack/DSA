package google.uniquePath3;

public class UniquePath3Driver {


  public static void main(String[] args) {
    System.out.println(new Solution().uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
  }
}


class Solution {
  int PathCount = 0;
  public int uniquePathsIII(int[][] grid) {

    int m = grid.length;
    int n = grid[0].length;
    int startI = 0;
    int startJ = 0;
    int count =0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

        if(grid[i][j] != -1 ){
          count++;
        }

        if(grid[i][j] ==1){
          startI =i;
          startJ = j;
        }
      }
    }

    boolean[][] visited = new boolean[m][n];
    dfs(grid,startI,startJ,visited,count,1);
    return PathCount;

  }

  private void dfs(int[][] grid,int i, int j,boolean[][] visited, int total, int currCount ){

    int m = grid.length;
    int n = grid[0].length;

    if(i<0 || j < 0 || i >= m || j >= n || visited[i][j]){
      return;
    }

    if(grid[i][j] == -1){
      return;
    }

    if(grid[i][j] == 2){
      if(currCount == total){
        PathCount++;
      }
      return;
    }

    visited[i][j] = true;

    dfs(grid,i+1,j,visited,total,currCount+1);
    dfs(grid,i,j+1,visited,total,currCount+1);
    dfs(grid,i-1,j,visited,total,currCount+1);
    dfs(grid,i,j-1,visited,total,currCount+1);
    visited[i][j] = false;

  }



}
