package graph.distinctIsland;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctIslandDriver {

  public static void main(String[] args) {

    int[][] grid = {
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    System.out.println(Solution.distinctIsland(grid,3,4));
  }
}

class Solution
{
  public static int distinctIsland(int [][] arr, int n, int m)
  {
    //write your code here

    boolean[][] visited = new boolean[arr.length][m];
    Set<List<String>> distinctIslands = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {

        if(arr[i][j] == 1 && !visited[i][j]){
          List<String> result = new ArrayList<>();
          dfs(arr,i,j,visited,result,i,j);
          distinctIslands.add(result);
        }
      }

    }
    return distinctIslands.size();

  }

  private static void dfs(int[][] arr,int i, int j,boolean[][] visited, List<String> result, int starI, int startJ){


    visited[i][j] = true;
    result.add((i-starI)+ " " +(j-startJ));
    int delRow[] ={-1,0,1,0};
    int delCol[] = {0,1,0,-1};

    for (int k = 0; k < delRow.length; k++) {


        int delI = i+delRow[k];
        int delJ = j+delCol[k];

        if(delI >=0 && delJ >=0 && delI < arr.length && delJ <arr[0].length && arr[delI][delJ] ==1 && !visited[delI][delJ]){
          dfs(arr,delI,delJ,visited,result,starI,startJ);
        }




    }

  }
}
