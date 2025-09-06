package graph.cityWithSmallestNeighBour;

import java.util.Arrays;

public class CityWithSamllestNeighBourDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {

    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(i!=j){
          dist[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    for (int i = 0; i < edges.length; i++) {

      int s = edges[i][0];
      int d = edges[i][1];
      int w = edges[i][2];

      dist[s][d] = w;
      dist[d][s] = w;
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {

          if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
            if(dist[i][k] + dist[k][j] < dist[i][j]){
              dist[i][j] = dist[i][k] + dist[k][j];
            }
          }
        }
      }
    }

    int[] neighBourWithingThresold = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if(dist[i][j] <= distanceThreshold){
          neighBourWithingThresold[i]++;
        }
      }
    }

    int min = Integer.MAX_VALUE;
    int node = -1;

    for (int i = 0; i < n; i++) {
      if(neighBourWithingThresold[i] <= min){
        min = neighBourWithingThresold[i];
        node = i;
      }
    }
    return node;



  }
}
