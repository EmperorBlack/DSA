package graph.mostStoneRemoved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MostStoneRemovedDriver {

  public static void main(String[] args) {

  }
}

//consider every row is a node and col is a node
class Solution {
  public int removeStones(int[][] stones) {

    int row =0;
    int col =0;

    for (int i = 0; i < stones.length; i++) {
      row = Math.max(stones[i][0],row);
      col = Math.max(stones[i][1],col);
    }

    DisjointSet set = new DisjointSet(row+1 + col +1);

    Set<Integer> usedNodes = new HashSet<>();
    for (int i = 0; i < stones.length; i++) {

      int src = stones[i][0];
      int dst = stones[i][1] + row + 1;

      if(set.findParent(src) != set.findParent(dst)){
        set.unionBySize(src,dst);
        usedNodes.add(src);
        usedNodes.add(dst);
      }
    }

    int count =0;
    for (int node : usedNodes) {

      if(set.parents.get(node) == node){
        count++;
      }

    }

    return stones.length-count;



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