package graph.largestIsland;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestIslandDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().largestIsland(new int[][]{{1,1},{1,0}}));;
  }
}

class Solution {
  public int largestIsland(int[][] grid) {


    int rows = grid.length;
    int cols = grid[0].length;
    DisjointSet set = new DisjointSet(rows*cols);

    int[] delRow = {0,1,0,-1};
    int[] delCol = {-1,0,1,0};
    int countOnes = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {

        if(grid[i][j] == 1){
          countOnes++;
          int srcNode = i*cols+j;
          for (int k = 0; k < 4; k++) {
            int delI = i+delRow[k];
            int delJ = j+delCol[k];

            if(delI >=0 && delJ >=0 && delI < rows && delJ < cols && grid[delI][delJ] == 1){
              int delNode = delI* cols + delJ;
              set.unionBySize(srcNode,delNode);
            }
          }
        }
      }
    }

    if(countOnes == rows*cols){
      return countOnes;
    }
    int maxSize = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {

        Set<Integer> neighbour = new HashSet<>();
        if(grid[i][j] == 0){
          int delMaxSize =1;
          for (int k = 0; k < 4; k++) {
            int delI = i+delRow[k];
            int delJ = j+delCol[k];

            if(delI >=0 && delJ >=0 && delI < rows && delJ < cols && grid[delI][delJ] == 1 ){
              int delNode = delI* cols + delJ;
              int upDelNode = set.findParent(delNode);
              if(!neighbour.contains(upDelNode)){
                delMaxSize = delMaxSize + set.size.get(upDelNode);
                neighbour.add(upDelNode);
              }
            }
          }
          maxSize = Math.max(maxSize,delMaxSize);
        }


      }
    }
    return maxSize;
  }

}

class DisjointSet{

  List<Integer> parents = new ArrayList<>();
  List<Integer> size = new ArrayList<>();

  public DisjointSet(int n) {

    for (int i = 0; i < n; i++) {
      parents.add(i);
      size.add(1);
    }

  }

  public int findParent(int node){
    if(parents.get(node) == node){
      return node;
    }

    int uP = findParent(parents.get(node));
    parents.set(node,uP);
    return uP;
  }

  public void unionBySize(int u, int v){

    int upU = findParent(u);
    int upV = findParent(v);
    if(upU == upV){
      return;
    }

    int sizeOfUpOfU  = size.get(upU);
    int sizeOfUpOfV = size.get(upV);

    if(sizeOfUpOfU > sizeOfUpOfV){
      parents.set(upV,upU);
      size.set(upU, sizeOfUpOfU+sizeOfUpOfV);
    }else{
      parents.set(upU,upV);
      size.set(upV, sizeOfUpOfU+sizeOfUpOfV);
    }

  }
}
