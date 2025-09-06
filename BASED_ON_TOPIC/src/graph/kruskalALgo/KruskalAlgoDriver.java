package graph.kruskalALgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalAlgoDriver {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    // Add rows to the list
    list.add(new ArrayList<>(Arrays.asList(1, 2, 6)));
    list.add(new ArrayList<>(Arrays.asList(2, 3, 2)));
    list.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
    list.add(new ArrayList<>(Arrays.asList(1, 0, 2)));

    System.out.println(Solution.minimumSpanningTree(list,4));
  }
}




  class Solution {

    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
      //Your code goes here
      DisjointSet set = new DisjointSet(n);
      edges.sort((e1, e2) -> Integer.compare(e1.get(2), e2.get(2)));

      int sum = 0;
      for (int i = 0; i < edges.size(); i++) {

        ArrayList<Integer> curr = edges.get(i);
        if(set.findParent(curr.get(0)) != set.findParent(curr.get(1))){
          set.unionByRank(curr.get(0),curr.get(1));
          sum = sum+ curr.get(2);
        }

      }
      return sum;
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

