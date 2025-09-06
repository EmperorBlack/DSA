package graph.bridgeInGraph;

import java.util.ArrayList;
import java.util.List;

public class BridgeInGraphDriver {

  public static void main(String[] args) {

  }
}

class Solution {

  static int time =0;
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < connections.size(); i++) {
      int src = connections.get(i).get(0);
      int dst = connections.get(i).get(1);

      graph.get(src).add(dst);
      graph.get(dst).add(src);
    }

    int[] disc = new int[n];
    int[] low = new int[n];
    boolean[] visited = new boolean[n];
    List<List<Integer>> result = new ArrayList<>();

    dfs(0,-1,disc,low,visited,graph,result);
    return result;

  }

  public void dfs(int node, int parent, int[] disc, int[] low, boolean[] visited , List<List<Integer>> graph, List<List<Integer>> result){

    visited[node] = true;

    for (int i = 0; i < graph.get(node).size(); i++) {

      int next = graph.get(node).get(i);
      if(next == parent){
        continue;
      }

      if(!visited[next]){
        disc[next] = low[next] = ++time;
        dfs(next,node,disc,low,visited,graph,result);
        low[node] = Math.min(low[node],low[next]);
      }else{
        low[node] = Math.min(low[node],low[next]);
      }

      if(low[next] > disc[node]){
        List<Integer> edge = new ArrayList<>();
        edge.add(node);
        edge.add(next);
        result.add(edge);
      }
    }

  }
}
