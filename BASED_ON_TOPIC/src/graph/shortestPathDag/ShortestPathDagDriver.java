package graph.shortestPathDag;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathDagDriver {

  public static void main(String[] args) {

    int[][] array = {
        {2, 0, 4},
        {0, 1, 3},
        {2, 1, 2}
    };

    int[] result = Solution_toposort.shortestPathInDAG(3, 3, array);
    System.out.println(Arrays.toString(result));
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


class Edge{
  int src;
  int dest;
  int weight;

  public Edge(int src, int dest, int weight) {
    this.src = src;
    this.dest = dest;
    this.weight = weight;
  }
}

class Solution {
  public static int[] shortestPathInDAG(int n, int m, int [][]edges) {

    ArrayList<Edge>[] graph = new ArrayList[n];

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < edges.length; i++) {

      int src = edges[i][0];
      int dst = edges[i][1];
      int weight = edges[i][2];

      graph[src].add(new Edge(src,dst,weight));
    }

    int[] dist = new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    Queue<Pair> queue = new PriorityQueue<>((p1,p2)->Integer.compare(p1.dist,p2.dist));

    queue.offer(new Pair(0,0));

    while (!queue.isEmpty()){

      Pair curr = queue.poll();

      for (int i = 0; i < graph[curr.node].size(); i++) {

        Edge next = graph[curr.node].get(i);
        if(dist[next.dest] > curr.dist + next.weight){
          queue.offer(new Pair(next.dest, curr.dist + next.weight));
          dist[next.dest] = curr.dist + next.weight;
        }
      }

    }

    for (int i = 0; i < dist.length; i++) {
      if(dist[i] == Integer.MAX_VALUE){
        dist[i] = -1;
      }
    }
    return dist;


  }
}

class Solution_toposort {
  public static int[] shortestPathInDAG(int n, int m, int [][]edges) {

    ArrayList<Edge>[] graph = new ArrayList[n];

    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < edges.length; i++) {

      int src = edges[i][0];
      int dst = edges[i][1];
      int weight = edges[i][2];

      graph[src].add(new Edge(src,dst,weight));
    }

    int[] dist = new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[0] =0;
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < visited.length; i++) {
      if(!visited[i]){
        dfs(graph,i,visited,stack);
      }
    }

    while(stack.peek() != 0){
      stack.pop();
    }
    while (!stack.isEmpty()){
      int curr = stack.pop();

      for (int i = 0; i < graph[curr].size(); i++) {
        Edge next = graph[curr].get(i);
        dist[next.dest] = Math.min(dist[next.dest],dist[curr] + next.weight);
      }

    }

    for (int i = 0; i < dist.length; i++) {
      if(dist[i] == Integer.MAX_VALUE){
        dist[i] = -1;
      }
    }

    return dist;


  }

  private static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> stack){
    visited[src] = true;

    for (int i = 0; i < graph[src].size(); i++) {
      Edge next = graph[src].get(i);
      if(!visited[next.dest]){
        dfs(graph, next.dest, visited, stack);
      }
    }

    stack.push(src);
  }
}

