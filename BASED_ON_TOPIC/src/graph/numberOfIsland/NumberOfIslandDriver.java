package graph.numberOfIsland;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslandDriver {

  public static void main(String[] args) {
    int[][] points = {
        {1, 1},
        {0, 1},
        {3, 3},
        {3, 4}
    };

    System.out.println(new Solution().numOfIslands(4,5,points));
  }
}


class Solution {

  public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
    //Your code here

    DisjointSet set = new DisjointSet(rows*cols);
    List<Integer> list = new ArrayList<>();
    int[][] matrix = new int[rows][cols];

    int[] delRow = {0,1,0,-1};
    int[] delCol = {-1,0,1,0};
    int totalIsland = 0;
    for (int i = 0; i < operators.length; i++) {

      int currI = operators[i][0];
      int currJ = operators[i][1];
      if(matrix[currI][currJ] == 1){

        list.add(totalIsland);
        continue;
      }
      matrix[currI][currJ] = 1;
      int srcNode = (currI*cols)+currJ;
      int tempIsland = 1;
      Set<Integer> neighbour = new HashSet<>();
      for (int j = 0; j < 4; j++) {

        int delI = currI + delRow[j];
        int delJ = currJ + delCol[j];

        if( delI >=0 && delJ >=0 && delI < rows && delJ < cols && matrix[delI][delJ] == 1){
          int delNode = (delI * cols) + delJ;
          neighbour.add(set.findParent(delNode));
          set.unionBySize(srcNode,delNode);
        }
      }
      totalIsland = totalIsland + tempIsland-(neighbour.size());
      list.add(totalIsland);

    }
    return list;
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

    if(node == parents.get(node)){
      return node;
    }

    int uP = findParent(parents.get(node));
    parents.set(node,uP);
    return uP;
  }

  public void unionBySize(int u , int v){

    int upU = findParent(u);
    int upV = findParent(v);

    if(upU == upV){
      return;
    }

    int upUSize = size.get(upU);
    int upVSize = size.get(upV);

    if(upUSize > upVSize){
      parents.set(upV,upU);
      size.set(upU,upUSize+upVSize);
    }else{
      parents.set(upU,upV);
      size.set(upV,upUSize+upVSize);
    }



  }
}

