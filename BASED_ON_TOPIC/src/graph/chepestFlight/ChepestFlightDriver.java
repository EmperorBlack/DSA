package graph.chepestFlight;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ChepestFlightDriver {

  public static void main(String[] args) {
    int[][] flights = {
        {0, 1, 100},
        {1, 2, 100},
        {0, 2, 500}
    };

    int[][] edges = {
        {0, 1, 5},
        {1, 2, 5},
        {0, 3, 2},
        {3, 1, 2},
        {1, 4, 1},
        {4, 2, 1}
    };

    int n = 5;
    System.out.println(new Solution().findCheapestPrice(n, edges, 0, 2, 2));

  }
}

class Edge{
  int dst;
  int weight;

  Edge( int dst, int weight){
    this.dst = dst;
    this.weight = weight;
  }
}

class Tuple{
  int node;
  int price;
  int stops;

  public Tuple(int node, int price, int stops) {
    this.node = node;
    this.price = price;
    this.stops = stops;
  }
}

class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    ArrayList<Edge>[] graph = new ArrayList[n];

    for (int i=0; i< graph.length;i++){
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < flights.length; i++) {

      int edgeSrc = flights[i][0];
      int edgeDst = flights[i][1];
      int edgeWeight= flights[i][2];

      graph[edgeSrc].add(new Edge(edgeDst,edgeWeight));
    }
    int[] dist = new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[src] = 0;

    Queue<Tuple> queue = new ArrayDeque<>();

    queue.offer(new Tuple(src,0,0));

    while (!queue.isEmpty()){

      Tuple curr = queue.poll();
      if(curr.node == dst || curr.stops > k ){
        continue;
      }

      for (int i = 0; i < graph[curr.node].size(); i++) {

        Edge next = graph[curr.node].get(i);
        if(dist[next.dst] > curr.price + next.weight){
          dist[next.dst] = curr.price + next.weight;
          queue.offer(new Tuple(next.dst,curr.price+ next.weight, curr.stops+1));
        }

      }
    }


    if(dist[dst] != Integer.MAX_VALUE){
      return dist[dst];
    }
    return -1;
  }
}

class Solution_2 {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    ArrayList<Edge>[] graph = new ArrayList[n];

    for (int i=0; i< graph.length;i++){
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < flights.length; i++) {

      int edgeSrc = flights[i][0];
      int edgeDst = flights[i][1];
      int edgeWeight= flights[i][2];

      graph[edgeSrc].add(new Edge(edgeDst,edgeWeight));
    }

    Queue<Tuple> queue = new PriorityQueue<>((p1,p2)->Integer.compare(p1.price,p2.price));

    queue.offer(new Tuple(src,0,0));

    while (!queue.isEmpty()){

      Tuple curr = queue.poll();
      if(curr.node == dst){
        return curr.price;
      }

      for (int i = 0; i < graph[curr.node].size(); i++) {

        Edge next = graph[curr.node].get(i);
        if(curr.stops <= k){
          queue.offer(new Tuple(next.dst,curr.price+ next.weight, curr.stops+1));
        }

      }
    }

    return -1;
  }
}




