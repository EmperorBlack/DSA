package graph.bipatriteGraph;

public class BipatriteDriver {

  public static void main(String[] args) {
//    System.out.println(new Solution().isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
  }

}

class Solution {
  public boolean isBipartite(int[][] graph) {

    int visited[] = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {

      if(visited[i] == 0){
        if(!dfs(graph,i,1,visited)){
          return false;
        }
      }
    }
    return true;


  }

  private boolean dfs(int[][] graph, int src, int color, int[] visited){
    visited[src] = color;

    for (int i = 0; i < graph[src].length; i++) {
      int next = graph[src][i];

      if(visited[next] == 0){
        if(!dfs(graph, next, color == 1 ? 2 : 1, visited)){
          return false;
        }
      }else{
        if(visited[next] == color){
          return false;
        }
      }
    }
    return true;
  }
}
