package graph.topoSortDFS;

import java.util.ArrayList;
import java.util.List;

public class TopoSortDFS {

  public static void main(String[] args) {

  }
}

class Solution {

  public static ArrayList<Integer> topoSort(int V, int[][] edges) {


    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {

      int src = edges[i][0];
      int dst = edges[i][1];
      graph.get(dst).add(src);
    }

    boolean[] visited = new boolean[V];
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      if(!visited[i]){
        dfs(graph,i,visited,result);
      }
    }
    return result;


  }

  private static void dfs(List<List<Integer>> graph,int src, boolean[] visited,ArrayList<Integer> result){

    visited[src] = true;

    for (int i = 0; i < graph.get(src).size(); i++) {

      int next = graph.get(src).get(i);
      if(!visited[next]){
        dfs(graph, next, visited, result);
      }
    }
    result.add(src);


  }
}
