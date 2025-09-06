package graph.printAdjecency;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjecencyDriver {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    list.set(2,0);
    System.out.println(list);
  }
}

class Solution {
  public List<List<Integer>> printGraph(int V, int edges[][]) {

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {

      int src = edges[i][0];
      int dst = edges[i][1];
      adj.get(src).add(dst);
      adj.get(dst).add(src);
    }
    return adj;
  }
}