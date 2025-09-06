package google.minnIncToEquilizeLeafPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinIncToEquDriver {

  public static void main(String[] args) {

    int[][] trips = {{1,2,3},{2,3,4},{3,4,5},{1,4,6}};
    Arrays.sort(trips,(t1, t2) -> Integer.compare(t1[2], t2[2]));
    Queue<int[]> queue = new PriorityQueue<>((t1,t2)-> Integer.compare(t1[2],t2[2]));
    int currentPassengers = 0;
  }
}



class Solution {
  int count = 0;
  public int minIncrease(int n, int[][] edges, int[] cost) {

    count =0;
    ArrayList<Integer>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < edges.length; i++) {
      int src = edges[i][0];
      int dst = edges[i][1];

      graph[src].add(dst);
      graph[dst].add(src);

    }

    equilise(graph,0,-1,cost);
    return count;

  }

  private long equilise(ArrayList<Integer>[] graph,int curr, int parent, int[] cost){


    List<Long> childCosts = new ArrayList<>();
    long maxCost = 0;
    for (int i = 0; i < graph[curr].size(); i++) {

      int child = graph[curr].get(i);
      if(child != parent){
        long childCost = equilise(graph,child,curr,cost);
        childCosts.add(childCost);
        maxCost = Math.max(maxCost, childCost);
      }
    }

    if(childCosts.isEmpty()){
      return cost[curr];
    }else{
      for (long childCost : childCosts) {
        if(childCost < maxCost){
          count++;
        }
      }
    }
    return maxCost + cost[curr];
  }
}
