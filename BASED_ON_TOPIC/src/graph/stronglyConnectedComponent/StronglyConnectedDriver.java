package graph.stronglyConnectedComponent;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedDriver {

}

class Solution {
  // Function to find number of strongly connected components in the graph.
  public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
    // code here

    int n = adj.size();
    boolean[] visited = new boolean[n];
    ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      transpose.add(new ArrayList<>());
    }

    for (int i = 0; i < adj.size(); i++) {
      for (int j = 0; j < adj.get(i).size(); j++) {
        int dst = adj.get(i).get(j);
        transpose.get(dst).add(i);
      }
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      if(!visited[i]){
        topoSort(i,adj,visited,stack);
        stack.add(i);
      }
    }
    visited = new boolean[n];
    int count =0;
    while(!stack.isEmpty()){
      int curr = stack.remove(stack.size()-1);
      if(!visited[curr]){
        dfs(curr,transpose,visited);
        count++;
      }
    }
    return count;
  }

  public void topoSort(int curr,ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack){
    visited[curr] = true;
    for (int i = 0; i < adj.get(curr).size(); i++) {
      int next = adj.get(curr).get(i);
      if(!visited[next]){
        topoSort(next,adj,visited,stack);
      }
    }
    stack.push(curr);
  }

  public void dfs(int curr,ArrayList<ArrayList<Integer>> adj, boolean[] visited){
    visited[curr] = true;
    for (int i = 0; i < adj.get(curr).size(); i++) {
      int next = adj.get(curr).get(i);
      if(!visited[next]){
        dfs(next,adj,visited);
      }
    }
  }
}