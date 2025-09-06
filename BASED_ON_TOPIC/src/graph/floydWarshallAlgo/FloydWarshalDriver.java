package graph.floydWarshallAlgo;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshalDriver {

  public static void main(String[] args) {
    
  }
}



class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    // Write your code here.

    int[][] graph = new int[n+1][n+1];
    int max = 1000000000;


    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph.length; j++) {

        if(i == j){
          graph[i][j] =0;
        }else{
          graph[i][j] = max;
        }
      }
    }

    for (int i = 0; i < edges.size(); i++) {
      
      int s = edges.get(i).get(0);
      int d = edges.get(i).get(1);
      int w = edges.get(i).get(2);
      graph[s][d] = w;
    }



    for (int k = 0; k < graph.length; k++) {
      for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph.length; j++) {

          if(graph[i][k] != max && graph[k][j] != max){
            if(graph[i][k] + graph[k][j] < graph[i][j]){
              graph[i][j] = graph[i][k] + graph[k][j];
            }
          }
        }
      }
    }

    return graph[src][dest];


  }

}
