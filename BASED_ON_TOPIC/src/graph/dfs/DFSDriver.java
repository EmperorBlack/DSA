package graph.dfs;

import java.util.ArrayList;

public class DFSDriver {

}

class Solution {
  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
    // Code here

    ArrayList<Integer> result = new ArrayList<>();
    dfsHelper(adj,new boolean[adj.size()],result,0);
    return result;
  }

  public void dfsHelper(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result, int curr){

    visited[curr] = true;
    result.add(curr);

    for (int i = 0; i < adj.get(curr).size(); i++) {
      int next = adj.get(curr).get(i);
      if(!visited[next]){
        dfsHelper(adj, visited, result, next);
      }
    }

  }
}
