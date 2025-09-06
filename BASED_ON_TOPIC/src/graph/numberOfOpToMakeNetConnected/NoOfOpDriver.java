package graph.numberOfOpToMakeNetConnected;

import java.util.ArrayList;
import java.util.List;

public class NoOfOpDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public int makeConnected(int n, int[][] connections) {

    DisjointSet set = new DisjointSet(n);
    int duplicate = 0;
    for (int i = 0; i < connections.length; i++) {
      int src = connections[i][0];
      int dst = connections[i][1];
      if(set.findParent(src) != set.findParent(dst)){
        set.unionBySize(src,dst);
      }else{
        duplicate++;
      }
    }

    int component = 0;
    for (int i = 0; i < set.parents.size(); i++) {
      if(set.parents.get(i) == i){
        component++;
      }
    }

    if(duplicate >= component-1){
      return component-1;
    }
    return -1;

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