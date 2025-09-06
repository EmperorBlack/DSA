package graph.articulationPoint;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointDriver {

  public static void main(String[] args) {

  }
}





class Solution {
    static int time =0;
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
      // code here

      time = 0;
      List<List<Integer>> graph = new ArrayList<>();
      for (int i = 0; i < V; i++) {
        graph.add(new ArrayList<>());
      }
      for (int i = 0; i < edges.length; i++) {

        int src = edges[i][0];
        int dst = edges[i][1];
        graph.get(src).add(dst);
        graph.get(dst).add(src);

      }

      int[] disc = new int[V];
      int[] low = new int[V];
      boolean[] visited = new boolean[V];
      boolean[] isArticulation = new boolean[V];
      ArrayList<Integer> result = new ArrayList<>();


      for (int i = 0; i < V; i++) {
        if(!visited[i]){
          dfs(i,-1,disc,low,visited,graph,isArticulation);
        }
      }
      for (int i = 0; i < isArticulation.length; i++) {
        if(isArticulation[i]){
          result.add(i);
        }
      }




      return !result.isEmpty() ? result : new ArrayList<Integer>(List.of(-1));
    }



  public static void dfs(int node, int parent, int[] disc, int[] low, boolean[] visited , List<List<Integer>> graph, boolean[] isArticulation){

    visited[node] = true;
    disc[node] = low[node] = time++;

    int child = 0;
    for (int i = 0; i < graph.get(node).size(); i++) {

      int next = graph.get(node).get(i);
      if(next == parent){
        continue;
      }

      if(!visited[next] ){
        dfs(next,node,disc,low,visited,graph,isArticulation);
        low[node] = Math.min(low[node],low[next]);
        if(low[next] >= disc[node] && parent != -1){
          isArticulation[node] = true;
        }
        child++;
      }else{
        low[node] = Math.min(low[node],disc[next]);
      }


    }
    if(parent == -1 && child > 1){
      isArticulation[node] = true;
    }

  }
}
