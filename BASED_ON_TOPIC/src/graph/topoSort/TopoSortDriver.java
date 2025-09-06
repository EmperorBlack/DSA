package graph.topoSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TopoSortDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public static ArrayList<Integer> topoSort(int V, int[][] edges) {
    // code here

    List<List<Integer>> graph = new ArrayList<>();
    int[] inDegree = new int[V];
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {

      int src = edges[i][0];
      int dst = edges[i][1];

      graph.get(src).add(dst);
      inDegree[dst]++;
    }

    ArrayList<Integer> result = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < V; i++) {
      if(inDegree[i] == 0){
        queue.offer(i);
      }
    }


    while (!queue.isEmpty()){
      int curr = queue.poll();
      result.add(curr);

      for (int i = 0; i < graph.get(curr).size(); i++) {

        int next = graph.get(curr).get(i);
        inDegree[next]--;
        if(inDegree[next] == 0){
          queue.offer(next);
        }
      }
    }

    if(result.size() == V){
      return result;
    }else {
      return new ArrayList<>();
    }
  }
}
