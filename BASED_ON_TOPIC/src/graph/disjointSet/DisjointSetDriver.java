package graph.disjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetDriver {

  public static void main(String[] args) {

  }
}

class DisjointSet{


  List<Integer> rank = new ArrayList<>();
  List<Integer> parents = new ArrayList<>();

  public DisjointSet(int node){
    for (int i = 0; i < node; i++) {
      rank.add(0);
      parents.add(i);
    }
  }

  public int findParent(int node){

    if(parents.get(node) == node){
      return node;
    }

    int uParent = findParent(parents.get(node));
    parents.set(node,uParent);
    return uParent;
  }

  public void unionByRank(int u, int v){

    int upU = findParent(u);
    int upV = findParent(v);

    if(upU == upV)
      return;

    int rankOfUpOfU = rank.get(upU);
    int rankOfUpOfV = rank.get(upV);

    if(rankOfUpOfU > rankOfUpOfV){
      parents.set(upV,upU);
    } else if (rankOfUpOfU < rankOfUpOfV) {
      parents.set(upU,upV);
    }else {
      parents.set(upV,upU);
      rank.set(upU,rankOfUpOfU+1);
    }
  }
}
