package graph.numberOfWays;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfWaysDriver {

  public static void main(String[] args) {

  }
}

class Edge{
  int dst;
  int weight;

  Edge(int dst, int weight) {
    this.dst = dst;
    this.weight = weight;
  }
}

class Pair{
  int node;
  long dist;

  public Pair(int node, long dist) {
    this.node = node;
    this.dist = dist;
  }
}

class Solution {
  public int countPaths(int n, int[][] roads) {

    ArrayList<Edge>[] graph = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList();
    }

    for (int i = 0; i < roads.length ; i++) {

      int src = roads[i][0];
      int dst = roads[i][1];
      int weight = roads[i][2];

      graph[src].add(new Edge(dst, weight));
      graph[dst].add(new Edge(src, weight));
    }

    long dist[] = new long[n];
    long ways[] = new long[n];

    for (int i = 0; i < n; i++) {
      dist[i] = Long.MAX_VALUE;
    }
    dist[0] = 0;
    ways[0] = 1;

    Queue<Pair> queue = new PriorityQueue<>((p1, p2) -> Long.compare(p1.dist, p2.dist));
    queue.offer(new Pair(0,0));

    while (!queue.isEmpty()){

      Pair curr = queue.poll();

      for (int i = 0; i < graph[curr.node].size(); i++) {

        Edge next = graph[curr.node].get(i);
        long newDistance = curr.dist + next.weight;
        if(dist[next.dst] > newDistance){
          dist[next.dst] = newDistance;
          queue.offer(new Pair(next.dst, newDistance));
          ways[next.dst] = ways[curr.node];
        } else if (dist[next.dst] == newDistance) {
          ways[next.dst] = (ways[curr.node] + ways[next.dst]) % 1000000007;
        }

      }

    }

    return (int)ways[n-1];

  }
}