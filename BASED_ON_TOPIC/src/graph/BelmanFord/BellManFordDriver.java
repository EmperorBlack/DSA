package graph.BelmanFord;

import java.util.Arrays;
import java.util.List;

public class BellManFordDriver {

  public static void main(String[] args) {

    List<List<Integer>> roads = List.of(
        List.of(1, 2, 4),
        List.of(1, 3, 3),
        List.of(2, 4, 7),
        List.of(3, 4, -2)
    );
    System.out.println(Arrays.toString(Solution.bellmonFord(4,4,1,roads)));


  }
}


class Solution {
  public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
    // Write your code here.

    int[] dist = new int[n+1];
    int max = 100000000;
    Arrays.fill(dist, max);

    dist[src] = 0;
    for (int i = 0; i < n-1; i++) {

      for (int j = 0; j < edges.size(); j++) {

        int dSrc = edges.get(j).get(0);
        int dDst = edges.get(j).get(1);
        int dWeight = edges.get(j).get(2);

        if(dist[dSrc] != max && (dist[dSrc] + dWeight) < dist[dDst]){
          dist[dDst] = dist[dSrc] + dWeight;
        }

      }

    }
    return dist;
  }
}
