package graph.cycleDetectionInDirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleDetectionDirectedDriver {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    list.add(new ArrayList<>(Arrays.asList(1, 2)));
    list.add(new ArrayList<>(Arrays.asList(4, 1)));
    list.add(new ArrayList<>(Arrays.asList(2, 4)));
    list.add(new ArrayList<>(Arrays.asList(3, 4)));
    list.add(new ArrayList<>(Arrays.asList(5, 2)));
    list.add(new ArrayList<>(Arrays.asList(1, 3)));


    System.out.println(Solution.detectCycleInDirectedGraph(5,list));
  }
}

class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList <ArrayList< Integer >> edges) {
    // Write your code here.

    ArrayList <ArrayList< Integer >> graph = new ArrayList < > ();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.size(); i++) {

      int src = edges.get(i).get(0);
      int dst = edges.get(i).get(1);
      graph.get(src).add(dst);
    }

    boolean[] visited = new boolean[n+1];
    boolean[] curPath = new boolean[n+1];

    for (int i = 1; i <= n; i++) {

      if(!visited[i]){
        if(dfs(graph,i,visited,curPath)){
          return true;
        }
      }
    }
    return false;

  }

  private static boolean dfs(ArrayList <ArrayList< Integer >> edges, int src, boolean[] visited, boolean[] currPath){

    visited[src] = true;
    currPath[src] = true;

    for (int i = 0; i < edges.get(src).size(); i++) {

      int next = edges.get(src).get(i);

      if(!visited[next]){
        if(dfs(edges, next, visited, currPath)){
          return true;
        }
      } else if (currPath[next]) {
        return true;
      }
    }

    currPath[src] = false;
    return false;


  }
}
