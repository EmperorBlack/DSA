package graph.UGcycleDetectionBFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CycleDetectionBFSDriver {

  public static void main(String[] args) {

  }
}
class Pair{
  int node;
  int parent;

  public Pair(int node, int parent) {
    this.node = node;
    this.parent = parent;
  }
}

class Solution {
  public boolean isCycle(int V, int[][] edges) {
    // Code here

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

    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {

      if(!visited[i] ){
        if(isCycleDetected(graph, V, visited, i)){
          return true;
        }
      }
    }
    return  false;


  }

  private boolean isCycleDetected(List<List<Integer>> graph, int V,boolean[] visited ,int src){
    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(src,-1));
    visited[src] = true;
    while (!queue.isEmpty()){

      Pair curr = queue.poll();

      for (int i = 0; i < graph.get(curr.node).size(); i++) {

        if(graph.get(curr.node).get(i) != curr.parent){
          if(visited[graph.get(curr.node).get(i)]){
            return true;
          }else{
            visited[graph.get(curr.node).get(i)] = true;
            queue.offer(new Pair(graph.get(curr.node).get(i), curr.node));
          }

        }

      }


    }
    return false;

  }
}


