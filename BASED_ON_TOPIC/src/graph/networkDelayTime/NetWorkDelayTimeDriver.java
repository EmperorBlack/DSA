package graph.networkDelayTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetWorkDelayTimeDriver {

  public static void main(String[] args) {
    int[][] edges = {
        {1, 2, 1},
        {2, 3, 2},
        {1, 3, 4}
    };
    int n = 3;
    System.out.println(new Solution().networkDelayTime(edges, n, 1));
  }
}

class Edge {
  int dst;
  int weight;

  Edge(int dst, int weight) {
    this.dst = dst;
    this.weight = weight;
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
  public int networkDelayTime(int[][] times, int n, int k) {

    ArrayList<Edge>[] graph = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] time : times) {
      int src = time[0];
      int dst = time[1];
      int weight = time[2];

      graph[src - 1].add(new Edge(dst -1, weight));
    }

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[k-1] = 0;

    Queue<Pair> queue = new PriorityQueue<>((p1,p2)->Integer.compare(p1.dist,p2.dist));
    queue.offer(new Pair(k-1,0));

    int maxDist = Integer.MIN_VALUE;
    while (!queue.isEmpty()){
      Pair curr = queue.poll();

      for (int i = 0; i < graph[curr.node].size(); i++) {
        Edge next = graph[curr.node].get(i);
        if(dist[next.dst] > curr.dist + next.weight){
          dist[next.dst] = curr.dist + next.weight;
          queue.offer(new Pair(next.dst, curr.dist + next.weight));
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if(dist[i] == Integer.MAX_VALUE){
        return -1;
      }
      maxDist = Math.max(maxDist, dist[i]);
    }

  return maxDist;
  }
}
