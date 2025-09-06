package graph.minimumMulToReachEnd;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinMulToReachEndDriver {

  public static void main(String[] args) {

  }
}

class Pair {

  int node;
  int dist;

  public Pair(int node, int dist) {
    this.node = node;
    this.dist = dist;
  }

}

class Solution {
  public int minimumMultiplications(int[] arr, int start, int end) {

    int mod = 100000;
    int[] dist = new int[mod];
    Arrays.fill(dist, Integer.MAX_VALUE);

    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(start, 0));

    while (!queue.isEmpty()){

      Pair curr = queue.poll();
      if(curr.node == end){
        return curr.dist;
      }

      for (int i = 0; i < arr.length; i++) {

        int next = curr.node * arr[i] % mod;
        int nextDist = curr.dist + 1;
        if(nextDist < dist[next]){
          dist[next] = nextDist;
          queue.offer(new Pair(next, nextDist));
        }

      }

    }


    return -1;
  }
}
