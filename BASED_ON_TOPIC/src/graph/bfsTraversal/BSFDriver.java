package graph.bfsTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BSFDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  // Function to return Breadth First Search Traversal of given graph.
  public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
    // code here

    boolean[] visited = new boolean[adj.size()];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(0);
    visited[0] = true;
    ArrayList<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()){

      int curr = queue.poll();
      result.add(curr);
      for (int i = 0; i < adj.get(curr).size(); i++) {
        int next = adj.get(curr).get(i);
        if(!visited[next]){
          queue.offer(next);
          visited[next] = true;
        }
      }
    }
    return result;

  }
}