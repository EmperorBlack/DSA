package graph.smallSwap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SmallSwapDriver {

  public static void main(String[] args) {


//    Arrays.sort("");
  }

}


class Solution {
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {


    int n = s.length();
    List<List<Integer>> graph = new ArrayList<>();
    for(int i =0;i<n;i++){
      graph.add(new ArrayList<>());
    }

    for(int i = 0;i < pairs.size();i++){

      int src = pairs.get(i).get(0);
      int dst = pairs.get(i).get(1);

      graph.get(src).add(dst);
      graph.get(dst).add(src);
    }

    boolean[] visited = new boolean[n];
    StringBuilder result = new StringBuilder(s);
    for(int i =0; i < n;i++){
      if(!visited[i]){
        List<Character> group = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        dfs(s,i,graph,visited, group, indexes);
        Collections.sort(group);
        Collections.sort(indexes);
        for (int j = 0; j < group.size(); j++) {
          result.setCharAt(indexes.get(j), group.get(j));
        }
      }
    }

    return result.toString();

  }

  private void dfs(String s,  int curr,List<List<Integer>> graph, boolean[] visited, List<Character> group,List<Integer> indexes){

    visited[curr] = true;
    group.add(s.charAt(curr));
    indexes.add(curr);

    for(int i =0; i< graph.get(curr).size();i++){

      int next = graph.get(curr).get(i);
      if(!visited[next]){
        dfs(s,next,graph,visited,group,indexes);
      }
    }
  }
}