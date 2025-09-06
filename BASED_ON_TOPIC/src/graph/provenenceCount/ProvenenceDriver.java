package graph.provenenceCount;

import java.util.ArrayList;
import java.util.List;

public class ProvenenceDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int findCircleNum(int[][] isConnected) {


    List<List<Integer>> adjList = new ArrayList<>();
    for(int i =0; i<isConnected.length;i++){
      adjList.add(new ArrayList<>());
    }
    for(int i =0; i<isConnected.length;i++){
      for(int j=0;j<isConnected[i].length;j++){

        if(i != j && isConnected[i][j] == 1){
          adjList.get(i).add(j);
          adjList.get(j).add(i);
        }

      }
    }

    int provinenceCount = 0;
    boolean[] visited = new boolean[adjList.size()];
    for(int i=0;i<visited.length;i++){

      if(!visited[i]){
        dfs(adjList,i,visited);
        provinenceCount++;
      }
    }
    return provinenceCount;

  }

  public void dfs(List<List<Integer>> adjList, int curr,boolean[] visited){

    visited[curr] = true;
    for(int i = 0; i< adjList.get(curr).size();i++){
      int next = adjList.get(curr).get(i);
      if(!visited[next]){
        dfs(adjList,next,visited);
      }
    }
  }
}

class Solution_2{
  public int findCircleNum(int[][] isConnected) {

    boolean[] visited = new boolean[isConnected.length];
    int count =0;
    for(int i=0;i<isConnected.length;i++){
      if(!visited[i]){
        dfs(isConnected,i,visited);
        count++;
      }
    }
    return count;
  }

  public void dfs(int[][] isConnected, int curr, boolean[] visited){

    visited[curr] = true;
    int[] currAdj = isConnected[curr];
    for(int i =0; i< currAdj.length;i++){

      if(currAdj[i] == 1 && !visited[i]){
        dfs(isConnected, i,visited);
      }

    }
  }
}
