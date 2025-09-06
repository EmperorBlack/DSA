package graph.shortestPathUg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathDriver {

  public static void main(String[] args) {

  }
}

class Pair{
  int node;
  int dist;

  public Pair(int node, int dist) {
    this.node = node;
    this.dist = dist;
  }
}
class Solution {
  // Function to find the shortest path from a source node to all other nodes
  public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
    // code here

    boolean[] visited = new boolean[adj.size()];
    int[] dist = new int[adj.size()];
    Arrays.fill(dist, -1);
    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(src,0));
    visited[src] = true;

    while (!queue.isEmpty()){
      Pair curr = queue.poll();
      dist[curr.node] =curr.dist;

      for (int i = 0; i < adj.get(curr.node).size(); i++) {

        int next = adj.get(curr.node).get(i);
        if(!visited[next]){
          visited[next] = true;
          queue.offer(new Pair(next, curr.dist+1));
        }

      }

    }
    return dist;



  }
}
