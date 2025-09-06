package graph.UGCycleDetactionDSF;

import java.util.ArrayList;
import java.util.List;

public class UGCycleDetectionDFSDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().isCycle(4,new int[][]{{1,2},{2,3}}));
  }
}


class Solution {
  public boolean isCycle(int V, int[][] edges) {
    // Code here

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int src = edge[0];
      int dst = edge[1];
      graph.get(src).add(dst);
      graph.get(dst).add(src);
    }
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if(!visited[i]){
        if(isCycleDetected(graph,i,visited,-1)){
          return true;
        }
      }
    }
    return false;


  }

  private boolean isCycleDetected(List<List<Integer>> graph, int src, boolean[] visited, int parent){

    visited[src] = true;
    for (int i = 0; i < graph.get(src).size(); i++) {

      int next = graph.get(src).get(i);
      if(next != parent){
        if(visited[next]){
          return true;
        } else if (isCycleDetected(graph,next,visited,src)) {
          return true;
        }
      }
    }
    return false;
  }
}