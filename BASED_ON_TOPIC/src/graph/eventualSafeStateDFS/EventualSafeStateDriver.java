package graph.eventualSafeStateDFS;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStateDriver {

  public static void main(String[] args) {

  }
}


  class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

      int n = graph.length;
      boolean[] visited = new boolean[n];
      boolean[] currPath = new boolean[n];
      boolean[] markSafe = new boolean[n];

      List<Integer> result = new ArrayList<>();

      for (int i = 0; i < n; i++) {

        if(!visited[i]){
          dfs(graph, i, visited, currPath,markSafe);
        }
      }

      for (int i = 0; i < n; i++) {
        if(markSafe[i]){
          result.add(i);
        }
      }


      return result;


    }

    private boolean dfs(int[][] graph, int src, boolean[] visited, boolean[] currPath, boolean[] markSafe){
      visited[src] = true;
      currPath[src] = true;

      for (int i = 0; i < graph[src].length; i++) {


        int next = graph[src][i];
        if(!markSafe[next]){
          if(!visited[next]){
            if(dfs(graph, next, visited, currPath,markSafe)){
              return true;
            }
          } else if (currPath[next]) {
            return true;
          }
        }


      }
      markSafe[src] = true;
      currPath[src] = false;
      return false;
    }
    
  }
